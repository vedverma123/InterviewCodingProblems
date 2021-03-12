package gfg;

import datastructure.linkedlist.Node;

public class LinkedListReverse {

    public Node reverse(Node head){
        if(head == null)
            return head;

        Node prev = null, current = head, next;
        while(current != null){
            next = current.getNode();
            current.setNode(prev);
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public static void main(String args[]){
        int[] input1 = {1,2,3,4,5,6,7};
        final Node node = new Node();
        LinkedListReverse obj = new LinkedListReverse();
        node.print(obj.reverse(node.createLinkedList(input1)));
    }


}
