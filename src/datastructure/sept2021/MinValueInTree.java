package datastructure.sept2021;

import datastructure.tree.Node;

public class MinValueInTree {

    public int minValue(Node root){
        if(root == null)
            return 0;
        return minValueRecursive(root);
    }

    private int minValueRecursive(Node root) {
        if(root == null)
            return Integer.MAX_VALUE;
        if(root.left == null && root.right == null){
            return root.value;
        }
        return Math.min(root.value, Math.min(minValueRecursive(root.left), minValueRecursive(root.right)));
    }

    public static void main(String[] args) {
        MinValueInTree obj = new MinValueInTree();
        Node root = obj.createBinaryTree();
        System.out.println(obj.minValue(root));

    }

    private Node createBinaryTree() {
        Node node3 = new Node(3, null, null);
        Node node8 = new Node(8, null, null);
        Node node21 = new Node(21, null, null);
        Node node4 = new Node(4, null, null);
        Node node6 = new Node(6, node3, node8);
        Node node10 = new Node(10, node6, node21);
        Node node30 = new Node(30, node4, null);
        return new Node(20, node10, node30);
    }

}
