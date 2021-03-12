package gfg;

import datastructure.linkedlist.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a singly linked list, swap kth node from beginning with kth node from end.
 * Swapping of data is not allowed, only pointers should be changed
 */
public class SwapKthNodeFromStartAndEnd {

   //Time Complexity - O(n)
   //Space Complexity - O(1)
   public Node swapKthNode(Node head, int k){
      if(head == null)
         throw new IllegalStateException();

      //calculate length and last to last node of the LinkedList.
      Map<String, Object> map = calculate(head);

      int size = (int) map.get("size");
      Node prevToTail = (Node) map.get("prev");
      //do nothing
      if(k < 1 || size == 1 || k > size || k == size/2 + 1)
         return head;

      //swap first and last node
      else if(k == 1 || k == size)
         head = swapFirstAndLast(prevToTail, head , head);

      else{
         Node current = head;
         Node firstPtr = null, secondPtr = null;

         int count = 0;
         while(current != null){
            if(count > k - 1)
               firstPtr = firstPtr == null ? head : firstPtr.getNode();

            if(count > size - k)
               secondPtr = secondPtr == null ? head : secondPtr.getNode();

            count ++;
            current = current.getNode();
         }
         secondPtr = secondPtr == null ? prevToTail : secondPtr;
         head= swap(firstPtr, secondPtr, head);
      }

      return head;
   }

   private Node swapFirstAndLast(Node first, Node second, Node head){
      Node temp = first.getNode();
      temp.setNode(head.getNode());
      first.setNode(second);
      second.setNode(null);
      return temp;
   }

   private Node swap(Node first, Node second, Node head ){
      Node temp1 = first.getNode();
      Node temp1Next = null;
      if (temp1 != null)
         temp1Next = temp1.getNode();

      Node temp2 = second.getNode();
      Node temp2Next = null;
      if (temp2 != null)
         temp2Next = temp2.getNode();

      second.setNode(temp1);
      if (temp1 != null)
         temp1.setNode(temp2Next);

      first.setNode(temp2);
      if (temp2 != null)
         temp2.setNode(temp1Next);
      return head;
   }

   public static void main(String[] args) {
      SwapKthNodeFromStartAndEnd obj = new SwapKthNodeFromStartAndEnd();
      int[] input = {1,2,3,4,5,6};
      int k = 3;
      Node head = obj.swapKthNode(obj.createLinkedList(input), k);
      obj.print(head);
   }

   private Map<String, Object> calculate(Node head) {
      int count = 0;
      Node current = head;
      Map<String, Object> map = new HashMap<>();
      Node prevToTail = null;
      while(current != null){
         if(count >= 1)
            prevToTail = prevToTail == null ? head : prevToTail.getNode();
         count ++;
         current = current.getNode();
      }
      map.put("size", count);
      map.put("prev", prevToTail);
      return map;
   }

   public void print(Node head){
      while(head != null){
         System.out.print(head.getValue());
         if(head.getNode() != null)
            System.out.print("->");
         head = head.getNode();
      }
   }

   private Node createLinkedList(int[] input) {
      return createNode(input, 0);
   }

   private Node createNode(int[] input, int i) {
      if(i == input.length)
         return null;
      return new Node(input[i], createNode(input, i + 1));
   }
}
