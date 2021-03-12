package algoexpert;

import datastructure.tree.Node;
import datastructure.tree.Tree;

public class MinHeightBST {

    public Node minHeightBST(int[] nums){
        if(nums == null || nums.length == 0)
            return null;
        Node root = null;
        Tree tree = new Tree();
        createMinBST(root, nums, 0, nums.length - 1, tree);
        return root;
    }

    private void createMinBST(Node root, int[] nums, int start, int end, Tree tree) {
        if(start > end)
            return;
        int mid = (start + end) / 2;
        int num = nums[mid];
        if(root == null){
            root = tree.createNode(num, null, null);
            tree.root = root;
        }
        else
            tree.insert(num);
        createMinBST(root, nums, start, mid - 1, tree);
        createMinBST(root, nums, mid + 1, end, tree);
    }

    public static void main(String[] args){
        MinHeightBST objMinHeightBST = new MinHeightBST();
        int[] nums = {1,2,5,7,10,13,14,15,22};
        objMinHeightBST.minHeightBST(nums);
    }

}
