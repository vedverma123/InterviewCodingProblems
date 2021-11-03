package datastructure.sept2021;

import datastructure.tree.Node;

public class ValidateBST {

    public boolean isBSTUsingIteration(Node root){
        if(root == null)
            throw new IllegalStateException();
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int min, int max) {
        if(root == null)
            return true;
        if(root.value > min && root.value <= max){
            return isBST(root.left, min, root.value) && isBST(root.right, root.value, max);
        }
        return false;
    }


    public boolean isBST(Node root){
        if(root == null){
            throw new IllegalStateException();
        }
        return isBSTRecursive(root);
    }

    private boolean isLeaf(Node root){
        return root.left == null && root.right == null;
    }

    private boolean isBSTRecursive(Node root){
        if(root == null || isLeaf(root))
            return true;
        if(root.left == null){
            return root.value <= root.right.value;
        }
        if(root.right == null){
            return root.value > root.left.value;
        }
        if(root.value > root.left.value && root.value <= root.right.value)
            return isBSTRecursive(root.left) && isBSTRecursive(root.right);
        return false;
    }

    public static void main(String[] args) {
        ValidateBST obj = new ValidateBST();
        Node root = obj.createBST();
        System.out.println(obj.isBSTUsingIteration(root));
    }

    private Node createBST() {
        Node node1 = new Node(1, null, null);
        Node node3 = new Node(3, null, null);
        Node node11 = new Node(11, null, null);
        Node node12 = new Node(12, node11, null);
        Node node2 = new Node(2, node1, node3);
        Node node8 = new Node(8, null, node12);
        return new Node(7, node2, node8);
    }
}
