package datastructure.tree;

public class Node{
   public int value;
   public Node left;
   public Node right;

   public int getValue() {
      return value;
   }

   public Node getLeft() {
      return left;
   }

   public Node getRight() {
      return right;
   }

   public void setLeft(Node left) {
      this.left = left;
   }

   public void setRight(Node right) {
      this.right = right;
   }

   public Node(int value, Node left, Node right){
      this.value = value;
      this.left = left;
      this.right = right;
   }

   @Override public String toString() {
      return "value = " + value ;
   }
}