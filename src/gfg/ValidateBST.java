package gfg;

import datastructure.tree.Node;

public class ValidateBST {

   public boolean validateBST(Node root){
      return validate(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
   }

   private boolean validate(Node node, int maxValue, int minValue) {
      if(node == null)
         return true;

      if(node.getValue() > minValue && node.getValue() < maxValue)
         return validate(node.getRight(), maxValue, node.getValue()) &&
               validate(node.getLeft(), node.getValue(), minValue);

      return false;

   }

   public static void main(String[] args) {
      ValidateBST obj = new ValidateBST();
      System.out.println(obj.validateBST(obj.createTree()));
   }

   private Node createTree() {
      Node node5 = new Node(19, null, null);
      Node node11 = new Node(11, null, null);
      Node node13 = new Node(18, null, null);
      Node node15 = new Node(15, node11, node13);
      return new Node(10, node5, node15);
   }

}
