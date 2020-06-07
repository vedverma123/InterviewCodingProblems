package gfg;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * The bottom view of a binary tree refers to the bottommost nodes present at their horizontal distance.
 * For the nodes of a binary tree, the horizontal distance is defined as follows:
 *
 * Horizontal distance of the root = 0
 * Horizontal distance of a ​left child = horizontal distance of its parent - 1
 * Horizontal distance of a right child = horizontal distance of its parent + 1
 *
 */
public class TreeBottomView {

   private class Node{
      int val;
      int horizontalDistance;
      Node left,right;

      public Node(int val, Node left, Node right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }

      @Override public String toString() {
         return "val = " + val + ", horizontalDistance = " + horizontalDistance;
      }
   }

   //Time complexity - O(n)
   //Space complexity - O(n)
   List<Node> getBottomViewNodes(Node root){
      if(root == null)
         return new ArrayList<>();

      Map<Integer, Node> map = new TreeMap<>();
      root.horizontalDistance = 0;

      Queue<Node> queue = new ArrayDeque<>();
      queue.offer(root);

      while(!queue.isEmpty()){
         Node current = queue.remove();

         map.put(current.horizontalDistance, current);
         if(current.left != null){
            current.left.horizontalDistance = current.horizontalDistance - 1;
            map.put(current.left.horizontalDistance, current.left);
            queue.offer(current.left);
         }

         if(current.right != null){
            current.right.horizontalDistance = current.horizontalDistance + 1;
            map.put(current.right.horizontalDistance, current.right);
            queue.offer(current.right);
         }
      }

      return new ArrayList<>(map.values());
   }

   public static void main(String[] args) {
      TreeBottomView obj = new TreeBottomView();
      final List<Node> bottomViewNodes = obj.getBottomViewNodes(obj.createTree());
      for(Node node : bottomViewNodes)
         System.out.print(node.val +" ");
   }

   private Node createTree() {
      Node node10 = new Node(10, null, null);
      Node node14 = new Node(14, null, null);

      Node node5 = new Node(5, null, null);
      Node node3 = new Node(3, node10, node14);
      Node node4 = new Node(4, null, null);
      Node node25 = new Node(25, null, null);

      Node node8 = new Node(8, node5, node3);
      Node node22 = new Node(22, node4, node25);

      return new Node(20, node8, node22);
   }

}
