package datastructure.sept2021;

public class TrieUsingArray {

    private Node root;
    private class Node{
        private char value;
        private Node[] children;
        private boolean isEndOfWord;

        public Node(char value){
            this.value = value;
            this.children = new Node[26];
        }
    }

    public static void main(String[] args) {
        TrieUsingArray obj = new TrieUsingArray();
        obj.insert("CAT");
        obj.insert("BAT");
        obj.insert("CAB");
        obj.insert("CAN");
        obj.insert("CATCH");
        obj.insert("BATTLE");
        System.out.println(obj.contains(null));
    }

    public boolean contains(String word){
        if(root == null || word == null)
            throw new IllegalStateException();

        Node current = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'A';
            if(current.children[index] == null)
                return false;
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    public void insert(String word) {
        if(root == null){
            root = new Node('*');
        }

        Node current = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'A';
            if(current.children[index] == null){
                current.children[index] = new Node(ch);
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

}
