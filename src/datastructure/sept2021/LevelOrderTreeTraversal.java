package datastructure.sept2021;

import java.util.ArrayDeque;
import java.util.Queue;

import datastructure.tree.Node;

public class LevelOrderTreeTraversal {

    public void printLevelOrder(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            System.out.println(queue.poll().value);
            queue.add(root.left);
            queue.add(root.right);
        }
    }

}
