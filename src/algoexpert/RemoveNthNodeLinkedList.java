package algoexpert;

//You have given a linked list, remove nth node from end .
public class RemoveNthNodeLinkedList {
   private static class Node{
      int val;
      Node next;

      public Node(int val) {
         this.val = val;
      }
   }

   //Time complexity - O(n) : length of the list
   //Space complexity : O(1)
   public Node remove(Node head, int nthFromEnd){
      if(head == null || nthFromEnd <= 0)
         throw new IllegalArgumentException();
      Node current = head, prev = null;
      int count = 0;
      while(current != null){
         if(count >= nthFromEnd)
            if(prev == null)
               prev = head;
            else
               prev = prev.next;

         count ++;
         current = current.next;
      }
      if(nthFromEnd > count)
         throw new IllegalArgumentException(nthFromEnd + " is higher than the linked list length.");

      //remove first node
      else if(nthFromEnd == count)
         return head.next;

      Node next = prev.next.next;
      prev.next = next;
      return head;
   }

   public static void main(String[] args) {
      Node head = getInput();
      RemoveNthNodeLinkedList obj = new RemoveNthNodeLinkedList();
      head = obj.remove(head, 1);
      print(head);
   }

   private static void print(Node head){
      while(head != null){
         System.out.println(head.val);
         head = head.next;
      }
   }

   private static Node getInput() {
      Node first = new Node(1);
      Node second = new Node(2);
      Node third = new Node(3);
      Node fourth = new Node(4);
      Node fifth = new Node(5);
      Node sixth = new Node(6);
      Node seventh = new Node(7);

      Node head = first;
      first.next = second;
      second.next = third;
      third.next = fourth;
      fourth.next = fifth;
      fifth.next = sixth;
      sixth.next = seventh;

      return head;
   }

}
