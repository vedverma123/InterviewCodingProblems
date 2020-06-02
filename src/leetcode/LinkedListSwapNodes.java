package leetcode;

import datastructure.linkedlist.Node;

public class LinkedListSwapNodes {

   public Node swapNodes(Node head){
      if(head == null || head.getNode() == null)
         return head;

      Node current = head;
      Node prev = null;
      head = current.getNode();
      while(current != null && current.getNode() != null){
         Node next = current.getNode();
         Node nextToNext = next.getNode();
         if(prev == null)
            prev = current;
         else{
            prev.setNode(next);
            prev = current;
         }
         current.setNode(nextToNext);
         next.setNode(current);
         current = current.getNode();
      }
      return head;
   }

   public void print(Node current){
      while(current != null){
         System.out.print(current.getValue());
         current = current.getNode();
      }

   }

   public static void main(String[] args) {
      LinkedListSwapNodes obj = new LinkedListSwapNodes();
      int[] values = {1,2,3};
      Node head = createLinkedList(values, 0);
      head = obj.swapNodes(head);
      obj.print(head);
   }

   private static Node createLinkedList(int[] values, int count) {
      if(count == values.length)
         return null;
      return new Node(values[count ++], createLinkedList(values, count));
   }

}
