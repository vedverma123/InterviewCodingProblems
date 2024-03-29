package algoexpert;

import datastructure.tree.Node;

public class BinaryTreeMaxPathSum {

   public int getMaxPathSum(Node root){
      if(root == null)
         return 0;
      if(root.getLeft() == null && root.getRight() == null)
         return root.getValue();

      int sum = 0;
      sum += getMaxPathSum(root.getLeft(), sum);
      sum = getMaxPathSum(root.getRight(), sum);
      sum += root.getValue();

      return sum;
   }

   private int getMaxPathSum(Node root, int sum) {
      if(root == null)
         return 0;

      if(root.getLeft() == null || root.getRight() == null)
         return root.getValue();
      else if (root.getLeft() == null)
         return root.getRight().getValue();
      else if (root.getRight() == null)
         return root.getLeft().getValue();
      else{
         sum += root.getValue();
         Node max = root.getLeft().getValue() > root.getRight().getValue() ? root.getLeft() : root.getRight();
         sum += getMaxPathSum(max, sum);
         return sum;
      }
   }

   public static void main(String[] args) {
      BinaryTreeMaxPathSum obj = new BinaryTreeMaxPathSum();
      Node root = obj.createBinaryTree();
      System.out.println(obj.maxPath(root));
   }

   private Node createBinaryTree() {
      Node node4 = new Node(4, null, null);
      Node node5 = new Node(5, null, null);
      Node node6 = new Node(6, null, null);
      Node node7 = new Node(7, null, null);
      Node node2 = new Node(2, node4, node5);
      Node node3 = new Node(3, node6, node7);
      return new Node(1, node2, node3);
   }


    public int maxPath(Node root){
        if(root == null)
            return 0;

        return maxPathSum(root)[1];
    }

    public int[] maxPathSum(Node root){
        if(root == null)
            return new int[]{0,0};

        int[] leftSum = maxPathSum(root.left);
        int[] rightSum = maxPathSum(root.right);

        int maxChildSumAsBranch = Math.max(leftSum[0], rightSum[0]);

        int value = root.value;

        int maxSumAsBranch = Math.max(maxChildSumAsBranch + value, value);
        int maxSumAsRoot = Math.max(leftSum[0] + rightSum[0] + value, maxSumAsBranch);
        int maxPathSum = Math.max(Math.max(leftSum[1], rightSum[1]), maxSumAsRoot);

        return new int[]{maxSumAsBranch, maxPathSum};
    }
}
