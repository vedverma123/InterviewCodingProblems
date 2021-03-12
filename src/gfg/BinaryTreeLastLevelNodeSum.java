package gfg;

import datastructure.tree.Node;

public class BinaryTreeLastLevelNodeSum {

    public int lastlevelSum(Node root){
        if(root == null)
            return 0;

        //first calculate the height
        int height = height(root);
        return lastLevelSum(root, height);
    }

    private int lastLevelSum(Node root, int height) {
        if(root == null)
            return 0;
        if(height == 1){
            return root.value;
        }
        return lastLevelSum(root.left, height - 1) + lastLevelSum(root.right, height - 1);
    }

    private int height(Node root) {
        if(root == null)
            return 0;

        return 1 + Math.max(height(root.left), height(root.right));
    }


    public static void main(String[] args){
        final BinaryTreeLastLevelNodeSum obj = new BinaryTreeLastLevelNodeSum();
        System.out.println(obj.lastlevelSum(obj.createTree()));
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
