package datastructure.sept2021;

import datastructure.tree.Node;
import datastructure.tree.Tree;

public class TreeEquals {

    public boolean equals(Node root1, Node root2){
        if(root1 == null && root2 == null){
            return true;
        }
        return compareTrees(root1, root2);
    }

    private boolean compareTrees(Node root1, Node root2) {
        if(root1 == null && root2 == null)
            return true;
        if((root1 == null && root2 != null) || (root1 != null && root2 == null) || root1.value != root2.value)
            return false;
        if(compareTrees(root1.left, root2.left) && compareTrees(root1.right, root2.right) && root1.value == root2.value)
            return true;
        return false;
    }

    private Node createBinaryTree1() {
        Node node3 = new Node(3, null, null);
        Node node8 = new Node(8, null, null);
        Node node21 = new Node(21, null, null);
        Node node4 = new Node(4, null, null);
        Node node6 = new Node(6, node3, node8);
        Node node10 = new Node(10, node6, node21);
        Node node30 = new Node(30, node4, null);
        return new Node(20, node10, node30);
    }

    private Node createBinaryTree2() {
        Node node3 = new Node(3, null, null);
        Node node8 = new Node(8, null, null);
        Node node21 = new Node(21, null, null);
        Node node4 = new Node(4, null, null);
        Node node6 = new Node(6, node3, node8);
        Node node10 = new Node(10, node6, node21);
        Node node30 = new Node(30, node4, null);
        return new Node(20, node10, node30);
    }

    public static void main(String[] args) {
        TreeEquals obj = new TreeEquals();
        final Node root1 = obj.createBinaryTree1();
        final Node root2 = obj.createBinaryTree2();
        System.out.println(obj.compareTrees(root1, root2));
    }

}
