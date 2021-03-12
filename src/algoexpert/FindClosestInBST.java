package algoexpert;

import datastructure.tree.Node;
import datastructure.tree.Tree;

public class FindClosestInBST {


   //space - O(1)
   //time - O(logn)
   public int find(Node root, int target){
      if(root == null)
         throw new IllegalStateException();

      int diff = Integer.MAX_VALUE;
      int closestNum = 0;
      while(root != null){
         int nodeValue = root.getValue();
         int newDiff = Math.abs(target - nodeValue);

         if(diff > newDiff){
            diff = newDiff;
            closestNum = nodeValue;
         }

         if(nodeValue > target)
            root = root.getLeft();
         else
            root = root.getRight();
      }
      return closestNum;
   }

   public static void main(String[] args) {
      Tree tree = new Tree();
      tree.insert(10);
      tree.insert(5);
      tree.insert(15);
      tree.insert(2);
      tree.insert(6);
      tree.insert(13);
      tree.insert(22);
      tree.insert(1);
      tree.insert(14);

      FindClosestInBST obj = new FindClosestInBST();
      int target = 12;
      System.out.print(obj.find(tree.root, target));
   }

}
