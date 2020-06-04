package gfg;

import datastructure.doublylinkedlist.Node;

public class ConvertBSTToDoublyLinkedList {

   private static Node prev;
   public Node getLinkedList(datastructure.tree.Node root){
      if(root == null)
         throw new IllegalArgumentException();

      Node head = null;
      head = traverseInOrder(root.getLeft(), head);
      Node listNode = createListNode(root);
      prev.setNext(listNode);
      listNode.setPrev(prev);
      prev = listNode;
      head = traverseInOrder(root.getRight(), head);
      return head;
   }

   private Node traverseInOrder(datastructure.tree.Node root, Node head) {
      if(root == null)
         return head;

      head = traverseInOrder(root.getLeft(), head);
      Node listNode = createListNode(root);
      if(head == null && prev == null)
         head = listNode;
      else{
         prev.setNext(listNode);
         listNode.setPrev(prev);
      }
      prev = listNode;
      head = traverseInOrder(root.getRight(), head);

      return head;
   }

   private Node createListNode(datastructure.tree.Node treeNode) {
      return new Node(treeNode.getValue(), null, null);
   }

   public static void main(String[] args) {
      ConvertBSTToDoublyLinkedList obj = new ConvertBSTToDoublyLinkedList();
      datastructure.tree.Node root = obj.createBST();
      Node head = obj.getLinkedList(root);
      obj.print(head);
   }

   private void print(Node head) {
      Node current = head;
      while(current != null){
         System.out.print(current.getValue());
         if(current.getNext() != null)
            System.out.print("<->");
         current = current.getNext();
      }
   }

   private datastructure.tree.Node createBST() {
      datastructure.tree.Node node1 = new datastructure.tree.Node(1, null,null);
      datastructure.tree.Node node3 = new datastructure.tree.Node(3, null,null);
      datastructure.tree.Node node7 = new datastructure.tree.Node(7, null,null);
      datastructure.tree.Node node15 = new datastructure.tree.Node(15, null,null);

      datastructure.tree.Node node2 = new datastructure.tree.Node(2, node1,node3);
      datastructure.tree.Node node8 = new datastructure.tree.Node(8, node7,node15);

      return new datastructure.tree.Node(5, node2,node8);
   }

}
