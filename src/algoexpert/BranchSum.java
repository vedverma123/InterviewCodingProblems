package algoexpert;

import datastructure.tree.Tree;
import datastructure.tree.Tree.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BranchSum {

   private boolean isLeaf(Node node){
      return node.getLeft() == null && node.getRight() == null;
   }


   //Time complexity - O(n)
   //Space complexity - O(logn) + list of sum
   //                  = O(logn) + O(n/2) =
   //                  O(n), because at a moment on stack we would have max logn method calls in case of balanced tree.
   // But in case of unbalanced tree(in below tree), we will have O(n).
   //        1
   //      2
   //    3
   //  4
   //5
   public Integer[] sum(Node root){
      if(root == null){
         Integer[] list = {0};
         return list;
      }

      List<Integer> list = new ArrayList<>();
      int sum = 0;
      sum(root, sum, list);
      return list.toArray(new Integer[0]);
   }

   private void sum(Node root, int sum, List<Integer> list) {
      if(root == null)
         return;

      sum += root.getValue();
      if(isLeaf(root)){
         list.add(sum);
         return;
      }

      sum(root.getLeft(), sum,list);
      sum(root.getRight(), sum, list);
   }

   public static void main(String[] args) {
      BranchSum obj = new BranchSum();
      Tree tree = new Tree();

      Node node6 = tree.createNode(6, null, null);
      Node node7 = tree.createNode(7, null, null);
      Node node8 = tree.createNode(8, null, null);
      Node node9 = tree.createNode(9, null, null);
      Node node10 = tree.createNode(10, null, null);

      Node node4 = tree.createNode(4, node8, node9);
      Node node5 = tree.createNode(5, node10, null);

      Node node2 = tree.createNode(2, node4, node5);
      Node node3 = tree.createNode(3, node6, node7);
      Node root = tree.createNode(1, node2, node3);
      tree.root = root;
      System.out.print(Arrays.toString(obj.sum(root)));
   }

}
