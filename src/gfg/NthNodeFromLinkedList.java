package gfg;

import datastructure.linkedlist.Node;

/**
 * Given a Linked List and a number n, write a function that returns the value at the n’th node from the end of the Linked List.
 */
public class NthNodeFromLinkedList {

   //Time Complexity - O(n)
   //Space Complexity - O(1)
   public int getNthVal(Node head, int n){
      if(head == null)
         throw new IllegalArgumentException();

      Node current = head;
      Node previous = null;
      int count = 1;
      while(current != null){
         if(count >= n - 1)
            if(previous == null)
               previous = head;
            else
               previous = previous.getNode();

         count ++;
         current = current.getNode();
      }

      if(previous != null)
         return previous.getValue();

      throw new IllegalArgumentException(n+" is greater than the length of the linked list");
   }

   public static void main(String[] args) {
      NthNodeFromLinkedList obj = new NthNodeFromLinkedList();
      int[] input = {1,2,3,4,5,6,7};
      Node head = obj.createLinkedList(input);
      System.out.print(obj.getNthVal(head, 8));
   }

   private Node createLinkedList(int[] input) {
      return createNode(input, 0);
   }

   private Node createNode(int[] input, int i) {
      if(i == input.length - 1)
         return null;
      return new Node(input[i], createNode(input, i + 1));
   }

}
