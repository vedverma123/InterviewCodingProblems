package gfg;

import datastructure.tree.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given a binary tree, a target node and an integer K,
 * the task is to find all the nodes that are at distance K from the given target node.
 *
 * https://www.geeksforgeeks.org/print-all-nodes-at-distance-k-from-given-node-iterative-approach/
 *
 */
public class TreeNodesAtKDistance {

   List<Node> getKDistanceNodes(Node root, Node target, int k){
      if(root == null || target == null)
         return new ArrayList<>();

      Queue<Node> queue = new ArrayDeque<>();
      Set<Node> visied = new HashSet<>();
      visied.add(target);
      int count = k;
      while(count >=1){
         if(queue.isEmpty()){
            Node parent = getParent(target, root);
            List<Node> children = getChildren(target, visied);
            if(parent != null && !visied.contains(parent)){
               visied.add(parent);
               queue.add(parent);
            }
            queue.addAll(children);
            visied.addAll(children);
         }
         else{
            int size = queue.size();
            for(int i = 0; i < size; i ++){
               Node current = queue.remove();
               if(!current.equals(root)){
                  Node parent = getParent(current, root);
                  if(parent != null && !visied.contains(parent)) {
                     queue.add(parent);
                     visied.add(parent);
                  }
               }
               List<Node> children = getChildren(current, visied);
               visied.addAll(children);
               queue.addAll(children);
            }
         }
         count --;
      }
      return new ArrayList<>(queue);
   }

   private List<Node> getChildren(Node current, Set<Node> visied) {
      List<Node> nodes = new ArrayList<>();
      if(current.getLeft() != null && !visied.contains(current.getLeft()))
         nodes.add(current.getLeft());
      if(current.getRight() != null && !visied.contains(current.getRight()))
         nodes.add(current.getRight());
      return nodes;
   }

   private Node getParent(Node target, Node root) {
      if(target.equals(root.getLeft()) || target.equals(root.getRight()))
         return root;

      Node current =  getParentRecursively(root.getLeft(), target);
      return current == null ? getParentRecursively(root.getRight(), target) : current;
   }

   private Node getParentRecursively(Node root, Node target){
      if(root.getLeft() == null && root.getRight() == null)
         return null;
      if(target.equals(root.getLeft()) || target.equals(root.getRight()))
         return root;
      Node current =  getParentRecursively(root.getLeft(), target);
      return current == null ? getParentRecursively(root.getRight(), target) : current;
   }

   public static void main(String[] args) {
      TreeNodesAtKDistance obj = new TreeNodesAtKDistance();
      Node root = obj.createTree();
      List<Node> nodes = obj.getKDistanceNodes(root, root, 1);
      for(Node node : nodes)
         System.out.println(node.getValue());
   }

   private Node createTree() {
      Node node10 = new Node(10, null, null);
      Node node14 = new Node(14, null, null);
      Node node12 = new Node(12, node10, node14);
      Node node4 = new Node(4, null, null);
      Node node8 = new Node(8, node4, node12);
      Node node22 = new Node(22, null, null);
      return new Node(20, node8, node22);
   }

}
