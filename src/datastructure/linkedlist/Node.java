package datastructure.linkedlist;

public class Node {

   private int value;
   private Node node;

   public Node() {
   }

   public Node(int value, Node node) {
      this.value = value;
      this.node = node;
   }

   @Override public String toString() {
      return "value = " + value;
   }

   public int getValue() {
      return value;
   }

   public void setValue(int value) {
      this.value = value;
   }

   public Node getNode() {
      return node;
   }

   public void setNode(Node node) {
      this.node = node;
   }

   public Node createLinkedList(int[] input) {
      return createNode(input, 0);
   }

   public Node createNode(int[] input, int i) {
      if(i == input.length)
         return null;
      return new Node(input[i], createNode(input, i + 1));
   }

   public void print(Node head){
      while(head != null){
         System.out.print(head.getValue());
         if(head.getNode() != null)
            System.out.print("->");
         head = head.getNode();
      }
   }
}

