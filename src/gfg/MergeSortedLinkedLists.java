package gfg;

import datastructure.linkedlist.Node;

/**
 * Given two sorted linked lists, merge them so that the resulting linked list is also sorted
 * Time Complexity - O(n+m)
 * Space complexity - O(1)
 */
public class MergeSortedLinkedLists {

   public Node mergeLists(Node head1, Node head2){
      if(head1 == null)
         return head2;
      if(head2 == null)
         return head1;

      Node mergedHead = new Node();

      Node tail = mergedHead;
      while(head1 != null && head2 != null){
         if(head1.getValue() >= head2.getValue()){
            tail.setNode(head2);
            head2 = head2.getNode();
         }else{
            tail.setNode(head1);
            head1 = head1.getNode();
         }
         tail = tail.getNode();
      }

      if(head1 != null)
         tail.setNode(head1);
      if(head2 != null)
         tail.setNode(head2);

      return mergedHead.getNode();
   }

   public static void main(String[] args) {
      MergeSortedLinkedLists obj = new MergeSortedLinkedLists();
      int[] input1 = {4,8,15,19};
      int[] input2 = {7,9,10,16,20};
      Node node = new Node();
      Node head1 = node.createLinkedList(input1);
      Node head2 = node.createLinkedList(input2);
      node.print(obj.mergeLists(head1, head2));
   }
}
