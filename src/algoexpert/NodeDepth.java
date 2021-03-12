package algoexpert;

import datastructure.tree.Node;
import datastructure.tree.Tree;

/**
 * O(n) time
 * O(h) space
 */
public class NodeDepth {

    public int depth(Node root){
        if(root == null)
            return 0;

        int depth = 0;
        return depth(depth, root);
    }

    private int depth(int depth, Node root) {
        if(root == null)
            return 0;
        return depth + depth(depth + 1, root.getLeft()) + depth(depth + 1, root.getRight());
    }


    public static void main(String[] args){
        NodeDepth obj = new NodeDepth();
        Tree tree = new Tree();

        Node node6 = tree.createNode(6, null, null);
        Node node7 = tree.createNode(7, null, null);
        Node node8 = tree.createNode(8, null, null);
        Node node9 = tree.createNode(9, null, null);
        Node node10 = tree.createNode(10, null, null);

        Node node4 = tree.createNode(4, node8, node9);
        Node node5 = tree.createNode(5, null, null);

        Node node2 = tree.createNode(2, node4, node5);
        Node node3 = tree.createNode(3, node6, node7);
        Node root = tree.createNode(1, node2, node3);
        tree.root = root;
        System.out.print(obj.depth(tree.root));
    }

}
