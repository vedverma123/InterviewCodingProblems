package datastructure.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {

   private Node root;

   public Trie(){
      root = new Node(' ');
   }

   public class Node{
      char value;
      Map<Character, Node> children;
      boolean isEndOfWord;

      public Node(){
         children = new HashMap<>();
      }

      public Node(char ch){
         this();
         this.value = ch;
      }

      public Node[] getChildren(){
         return children.values().toArray(new Node[0]);
      }

      public Node getChild(char ch){
         return children.get(ch);
      }

      public void removeChild(char ch){
         children.remove(ch);
      }

      public void addChild(char ch){
         children.put(ch, new Node(ch));
      }
   }

   public boolean contains(String word){
      if(root == null || word == null){
         return false;
      }
      Node current = root;
      for(char ch : word.toCharArray()){
         if(current == null || current.getChild(ch) == null)
            return false;
         if(current.getChild(ch).value != ch)
            return false;
         current = current.getChild(ch);
      }

      return current.isEndOfWord;
   }

   public void insert(String word){
      Node current = root;
      for(char ch : word.toCharArray()){
         if(current.getChild(ch) == null)
            current.addChild(ch);
         current = current.getChild(ch);
      }
      current.isEndOfWord = true;
   }

   public void traverse(){
      traverse(root);
   }

   private void traverse(Node root){
      for(Node node : root.getChildren())
         if(node != null)
            traverse(node);
   }

   public void remove(String word){
      if(word == null || root == null)
         return;
      remove(root, 0, word);
   }

   private void remove(Node node, int index, String word) {
      if(index == word.length()){
         node.isEndOfWord = false;
         return;
      }

      char ch = word.charAt(index);
      Node child = node.getChild(ch);
      if(child == null)
         return;

      remove(child, ++index, word);

      if(child.children.size() == 0 && !child.isEndOfWord){
         node.removeChild(ch);
      }
   }

   public List<String> autoComplete(String word){
      List<String> suggestions = new ArrayList<>();
      if(root == null || word == null)
         return suggestions;
      String currentWord = "";
      suggestionForWord(root, word, suggestions, 0, currentWord);
      return suggestions;
   }

   private void suggestionForWord(Node root, String word, List<String> suggestions, int index, String currentWord) {
      if(index == word.length())
         return;

      char ch = word.charAt(index);
      Node child = root.getChild(ch);

      if(child == null)
         return;

      currentWord += ch;
      if(child.isEndOfWord && index == word.length() - 1)
         suggestions.add(currentWord);

      suggestionForWord(child, word, suggestions, ++index, currentWord);

      if(index == word.length())
         addSuggestions(child, suggestions, currentWord);
   }

   private void addSuggestions(Node child, List<String> suggestions, String currentWord) {
      if(child == null)
         return;
      for(Node node : child.getChildren()){
         String word = currentWord + node.value;
         if(node.isEndOfWord)
            suggestions.add(word);
         addSuggestions(node, suggestions, word);
      }
   }

   public static void main(String[] args) {
      Trie trie = new Trie();
      trie.insert("cat");
      trie.insert("catch");
      trie.insert("can");
      trie.insert("cab");
      trie.insert("canada");
      trie.insert("car");
      trie.insert("card");
      trie.insert("care");
      trie.insert("careful");
      trie.insert("egg");
//      datastructure.array.trie.traverse();
//      datastructure.array.trie.remove("cat");
      System.out.println(trie.autoComplete(""));
   }

}
