package algoexpert;

import datastructure.tree.Node;
import datastructure.tree.Tree;

public class InvertBinaryTree {

   //Time complexity - O()
   //Space complexity - o(logn)
   public void invert(Node root){
      if(root.getLeft() == null && root.getRight() == null)
         return;

      else if(root.getLeft() != null && root.getRight() == null)
         root.setRight(root.getLeft());

      else if(root.getRight() != null && root.getLeft() == null)
         root.setLeft(root.getRight());

      else{
         Node temp = root.getLeft();
         root.setLeft(root.getRight());
         root.setRight(temp);
      }

      invert(root.getLeft());
      invert(root.getRight());
   }

   public static void main(String[] args) {
      InvertBinaryTree obj = new InvertBinaryTree();
      Tree tree = new Tree();
      Node node8 = tree.createNode(8, null, null);
      Node node9 = tree.createNode(9, null, null);
      Node node4 = tree.createNode(4, node8, node9);
      Node node5 = tree.createNode(5, null, null);
      Node node6 = tree.createNode(6, null, null);
      Node node7 = tree.createNode(7, null, null);

      Node node2 = tree.createNode(2, node4, node5);
      Node node3 = tree.createNode(3, node6, node7);

      Node node1 = tree.createNode(1, node2, node3);
      tree.root = node1;
      obj.invert(tree.root);
   }

}
