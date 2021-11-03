package algoexpert;

import datastructure.linkedlist.Node;

public class ShiftLinkedList {

   public Node shiftLinkedList(Node head, int k){
      Node current = head , prev = head;
      int count = 0;

      int length = 0;
      while(current != null){
         current = current.getNode();
         length ++;
      }
      if(Math.abs(k) > length){
         k = k % length;
      }
      if(k == 0)
         return head;
      else if(k < 0){
         k = length + k;
      }

      current = head;
      while (current.getNode() != null){
         if(count >= k)
            prev = prev.getNode();
         current = current.getNode();
         count ++;
      }
      Node next = prev.getNode();
      current.setNode(head);
      prev.setNode(null);
      head = next;
      return head;
   }

   public static void main(String[] args) {
      ShiftLinkedList obj = new ShiftLinkedList();
      int[] input = {1,2,3,4,5};
      final Node head = new Node().createLinkedList(input);
      head.print(obj.shiftLinkedList(head,29));
   }

}
