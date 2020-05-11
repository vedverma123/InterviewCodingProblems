package datastructure.tree;

import datastructure.tree.Tree.Node;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelOrder {

   public void printLevelOrder(Node root){
      if(root == null)
         return;

      System.out.println(root.value);
      Queue<Node> queue = new ArrayDeque<>();
      queue.add(root.left);
      queue.add(root.right);
      printLevelOrder(queue, new LinkedList<>());

   }

   private void printLevelOrder(Queue<Node> queue, LinkedList<Node> nodes) {
      if(queue.isEmpty())
         return;

      while(!queue.isEmpty()){
         Node node = queue.remove();
         nodes.add(node);
         System.out.print(node.value);
      }
      System.out.println();
      while(!nodes.isEmpty()){
         Node node = nodes.remove();
         if(node.left != null)
            queue.add(node.left);
         if(node.right != null)
            queue.add(node.right);
      }
      printLevelOrder(queue, nodes);
   }

   public static void main(String[] args) {
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


      PrintLevelOrder obj = new PrintLevelOrder();
      obj.printLevelOrder(tree.root);
   }

}
