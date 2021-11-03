package algoexpert;

import datastructure.linkedlist.Node;

//Find out the node where loop in a linked list originate
//Time - O(n)
// Space - O(1)

public class LoopOriginateNodeLinkedList {

    private Node head;
    public LoopOriginateNodeLinkedList(){
        head = new Node();
    }

    public Node findLoopOriginateNode_SecondApproach(Node head){
        Node first = head.getNode();
        Node second = head.getNode().getNode();
        while(first != second){
            first = first.getNode();
            second = second.getNode().getNode();
        }
        first = head;
        while(first != second){
            first = first.getNode();
            second = second.getNode();
        }
        return first;
    }

    //The only drawback here is we are changing the actual linked list.
    public Node findLoopOriginateNode(Node head){
        Node temp = new Node();
        Node current = head;
        while(current != null){
            if(current.getNode() == null)
                return null;

            //get the loop originating node.
            if(current.getNode() == temp)
                return current;

            Node next = current.getNode();
            current.setNode(temp);
            current = next;
        }
        return null;
    }

    public static void main(String[] args) {
        LoopOriginateNodeLinkedList obj = new LoopOriginateNodeLinkedList();
        obj.head = obj.createLinkedListWithLoop();
        Node loopOriginatingNode = obj.findLoopOriginateNode_SecondApproach(obj.head);
        if(loopOriginatingNode == null)
            System.out.println("No loop");
        else
            System.out.println("Loop at Node : " + loopOriginatingNode.getValue());
    }

    private Node createLinkedListWithLoop() {
        Node node7 = new Node(7, null);
        Node node6 = new Node(6, node7);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);
        node7.setNode(node4);
        return node1;
    }

}
