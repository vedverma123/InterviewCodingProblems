package algoexpert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//Space - O(nm + ws)
//Time - O(nm*8^s + ws)
public class BoggleBoardGame {

    class Trie{
        private Node root;
        public Trie(){
            root = new Node(' ');
        }

        public void insert(String word){
            Node current = root;
            for(char ch : word.toCharArray()){
                if(current.getChild(ch) == null)
                    current.addChild(ch);
                current = current.getChild(ch);
            }
            current.isEndOfWord = true;
            current.finalWord = word;
        }
    }

    class Node{

        private char label;
        private Map<Character, Node> children;
        private boolean isEndOfWord;
        private String finalWord;

        public Node(){
            this.children = new HashMap<>();
        }
        public Node(char label) {
            this();
            this.label = label;
        }

        public Map<Character, Node> getChildren() {
            return children;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public Node getChild(char ch){
            return getChildren().get(ch);
        }

        public void addChild(char ch){
            children.put(ch, new Node(ch));
        }
    }

    public String[] getMatchingWords(char[][] letters, String[] words) {
        if (letters == null && letters.length == 0)
            return new String[0];

        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }

        int rows = letters.length;
        int cols = letters[0].length;

        boolean[][] visited = new boolean[rows][cols];
        Set<String> finalWords = new HashSet<>();

        final Map<Character, Node> children = trie.root.getChildren();
        for(int row = 0; row < rows; row ++){
            for(int col = 0; col < cols ; col ++){
                //got the character in the boggle board
                if(children.containsKey(letters[row][col])){
                    exploreFurther(row, col, visited, letters, children, finalWords, trie);
                }
            }
        }
        return finalWords.stream().toArray(String[]::new);
    }

    private void exploreFurther(int row, int col, boolean[][] visited, char[][] letters,
                                Map<Character, Node> children, Set<String> finalWords, Trie trie) {
        if(row < 0 || row >= letters.length || col < 0 || col >= letters[0].length)
            return;
        if(visited[row][col])
            return;
        char ch = letters[row][col];
        Node current = children.get(ch);
        if(current == null)
            return;

        if(ch == current.label){
            visited[row][col] = true;
            if(current.isEndOfWord()){
                finalWords.add(current.finalWord);
                visited[row][col] = false;
                //return;
            }
            exploreFurther(row - 1, col + 1, visited, letters, current.getChildren(), finalWords, trie);
            exploreFurther(row, col + 1, visited, letters, current.getChildren(), finalWords, trie);
            exploreFurther(row + 1, col + 1, visited, letters, current.getChildren(), finalWords, trie);
            exploreFurther(row + 1, col, visited, letters, current.getChildren(), finalWords, trie);
            exploreFurther(row + 1, col - 1, visited, letters, current.getChildren(), finalWords, trie);
            exploreFurther(row, col - 1, visited, letters, current.getChildren(), finalWords, trie);
            exploreFurther(row - 1, col - 1, visited, letters, current.getChildren(), finalWords, trie);
            exploreFurther(row - 1, col, visited, letters, current.getChildren(), finalWords, trie);
            visited[row][col] = false;
        }
    }

    public static void main(String[] args) {
        char[][] letters = {{'t','h','i','s','i','s','a'},
                            {'s','i','m','p','l','e','x'},
                            {'b','x','x','x','x','e','b'},
                            {'x','o','g','g','l','x','o'},
                            {'x','x','x','d','t','r','a'},
                            {'r','e','p','e','a','d','x'},
                            {'x','x','x','x','x','x','x'},
                            {'n','o','t','r','e','-','p'},
                            {'x','x','d','e','t','a','e'}};
        String[] words = {"this","is","a","not","simple","boggle","board","test","repeated","notre-peated"};
        System.out.println(Arrays.toString(new BoggleBoardGame().getMatchingWords(letters, words)));
    }
}
