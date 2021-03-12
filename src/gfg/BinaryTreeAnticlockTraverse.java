package gfg;
//		       1
//		2			  3
//  4		5	6			7
//8								9
//							10
//output = [1 10 3 2 8 9 7 5 6 4]
//https://www.geeksforgeeks.org/anti-clockwise-spiral-traversal-of-a-binary-tree/


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import datastructure.tree.Node;


public class BinaryTreeAnticlockTraverse {
    public void binaryTreeTraversal(Node root){
        if(root == null)
            return ;

        Map<Integer, List<Integer>> nodeHeightMap = new HashMap();

        Queue<Node> queue1 = new ArrayDeque();
        Queue<Node> queue2 = new ArrayDeque();
        queue1.add(root);
        int height  = 1;
        populateMap(queue1, queue2, nodeHeightMap, height);

        int end = nodeHeightMap.size();
        int start = 1;
        while(start <= end){
            List<Integer> nodes = nodeHeightMap.get(start);
            //reverse the nodes
            reverse(nodes);
            System.out.print(nodeHeightMap.get(end).toString() + " ");
            start ++;
            end --;
        }

    }

    public void reverse(List<Integer> nodes){
        int size = nodes.size();
        for(int i = size - 1; i >= 0; i --)
            System.out.print(nodes.get(i) + " ");
    }

    public void populateMap(Queue<Node> queue1, Queue<Node> queue2, Map<Integer, List<Integer>> nodeHeightMap, int height){
        if(queue1.isEmpty())
            return;

        List<Integer> nodes = new ArrayList();
        while(!queue1.isEmpty()){
            Node current = queue1.remove();
            nodes.add(current.value);

            if(current.left != null)
                queue2.add(current.left);
            if(current.right != null)
                queue2.add(current.right);
        }
        nodeHeightMap.put(height, nodes);
        while(!queue2.isEmpty()){
            queue1.add(queue2.remove());
        }

        populateMap(queue1, queue2, nodeHeightMap, height + 1);
    }

    public static void main(String[] args){
        BinaryTreeAnticlockTraverse obj = new BinaryTreeAnticlockTraverse();
        obj.binaryTreeTraversal(obj.createTree());
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
