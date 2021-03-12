package gfg;

import datastructure.tree.Node;
import datastructure.tree.Tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintLevelOrderTreeTraversal {

   public void levelTraverse(Node root){
      if(root == null)
         return;
      Queue<Node> q1 = new ArrayDeque<>();
      Queue<Node> q2 = new ArrayDeque<>();
      q1.add(root);
      traverse(q1,q2);
   }

   public void traverse(Queue<Node> q1, Queue<Node> q2){
      if(q1.isEmpty())
         return;

      while(!q1.isEmpty()){
         Node current = q1.remove();
         System.out.print(current.value + " ");
         if(current.left != null)
            q2.add(current.left);
         if(current.right != null)
            q2.add(current.right);
      }

      System.out.println();
      while(!q2.isEmpty()){
         q1.add(q2.remove());
      }

      traverse(q1, q2);
   }

   public static void main(String[] args){
      Tree tree = new Tree();

      Node node4 = tree.createNode(4, null, null);
      Node node5 = tree.createNode(5, null, null);

      Node node8 = tree.createNode(8, null, null);
      Node node9 = tree.createNode(9, null, null);

      Node node6 = tree.createNode(6, node8, node9);
      Node node7 = tree.createNode(7, null, null);

      Node node2 = tree.createNode(2, node4, node5);
      Node node3 = tree.createNode(3, node6, node7);

      Node node1 = tree.createNode(1, node2, node3);
      tree.root = node1;

      PrintLevelOrderTreeTraversal obj = new PrintLevelOrderTreeTraversal();
      obj.levelTraverse(tree.root);

   }

}
