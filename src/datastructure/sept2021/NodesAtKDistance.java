package datastructure.sept2021;

import datastructure.tree.Node;

public class NodesAtKDistance {

    public void printNodesAtKDistance(Node root, int k){
        if(root == null){
            throw new IllegalStateException();
        }
        printNodes(root, k, 0);
    }

    private void printNodes(Node root, int k, int count) {
        if(root == null)
            return;
        if(count == k){
            //print nodes here.
            System.out.println(root.value);
        }
        printNodes(root.left, k, count + 1);
        printNodes(root.right, k, count + 1);
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

    public static void main(String[] args) {
        NodesAtKDistance obj = new NodesAtKDistance();
        Node root = obj.createBinaryTree();
        obj.printNodesAtKDistance(root, 2);
    }
}
