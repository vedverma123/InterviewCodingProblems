package gfg;

import java.util.Stack;

import datastructure.linkedlist.Node;

/**
 * Alternate reversal of linked list in a group of size k.
 * Like the first group should be reversed, the second group should be the same, the third should be reversed,
 * the fourth should be the same, etc.
 */
public class LinkedListAlternateReversal {

    public Node reverseLinkedList(Node head, int k){

        Node prev = null, current = head, next = null;
        int count = 0;
        while(count < k && current != null){
            next = current.getNode();
            current.setNode(prev);
            prev = current;
            current = next;
            count ++;
        }

        if(head != null){
            head.setNode(current);
        }

        count = 0;
        while(count < k - 1 && current != null){
            current = current.getNode();
            count ++;
        }

        if(current != null){
            current.setNode(reverseLinkedList(current.getNode(), k));
        }

        return prev;
    }

    public static void main(String args[]){
        int[] input1 = {1,2,3,4,5,6,7};
        final Node node = new Node();
        LinkedListAlternateReversal obj = new LinkedListAlternateReversal();
        node.print(obj.reverseLinkedList(node.createLinkedList(input1), 2));
    }

}
