package gfg;

/**
 * Given an integer K and a linked list in which each node stores a single character.
 * The task is to join every K consecutive nodes of the linked list to form a single word.
 * Finally, print the string obtained by joining these words (space separated).
 */
public class JoinKConsecutiveNodes {

   private class Node{
      char ch;
      Node next;

      public Node(char ch, Node next) {
         this.ch = ch;
         this.next = next;
      }
   }

   public String joinNodes(Node head, int k){
      StringBuilder sb = new StringBuilder();
      if(head == null)
         return sb.toString();

      Node current = head;
      int count = 0;
      while(current != null){
         if(count == k)
            sb.append(" ");
         sb.append(current.ch);
         current = current.next;
         count ++;
      }

      return sb.toString();
   }

   public static void main(String[] args) {
      JoinKConsecutiveNodes obj = new JoinKConsecutiveNodes();
      char[] chars = {'a','b','c','d','e','f'};
      int k = 4;
      System.out.println(obj.joinNodes(obj.createLinkedList(chars), k));
   }

   private Node createLinkedList(char[] chars) {
      return createNode(chars, 0);
   }

   private Node createNode(char[] chars, int i) {
      if(i == chars.length)
         return null;
      return new Node(chars[i], createNode(chars, i + 1));
   }

}
