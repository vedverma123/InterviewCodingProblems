package datastructure.linkedlist;

public class LinkedList {

   private Node first;
   private Node last;
   private int size;

   public LinkedList(){
      first = new Node();
      last = new Node();
   }

   public void addFirst(int item){
      Node node = new Node();
      node.setValue(item);
      if(first.getNode() != null){
         Node temp = first.getNode();
         first.setNode(node);
         node.setNode(temp);
      }else{
         first.setNode(node);
         last.setNode(node);
      }
      size ++;
   }

   public void addLast(int item){
      Node node = new Node();
      node.setValue(item);
      if(last.getNode() != null){
         Node temp = last.getNode();
         last.setNode(node);
         temp.setNode(node);
      }else{
         last.setNode(node);
         first.setNode(node);
      }
      size ++;
   }

   public void deleteFirst(){

      //if there is only 1 node
      if(first.getNode().equals(last.getNode())){
         first.setNode(null);
         last.setNode(null);
      }
      //if more than one node
      else{
         Node firstNode = first.getNode();
         Node newFirstNode = firstNode.getNode();
         firstNode.setNode(null);
         first.setNode(newFirstNode);
      }
      size --;
   }

   public void deleteLast(){
      //if there is only 1 node
      if(first.getNode().equals(last.getNode())){
         first.setNode(null);
         last.setNode(null);
      }
      //if more than one node
      else{
         Node prevNode = null;
         Node node = first.getNode();
         while(node.getNode() != null){
            prevNode = node;
            node = node.getNode();
         }
         prevNode.setNode(null);
         last.setNode(prevNode);
      }
      size --;
   }

   public void delete(int item){
      Node node = first.getNode();
      Node prevNode = null;
      boolean isItemFound = false;
      do{
         if(node.getValue() != item){
            prevNode = node;
            node = node.getNode();
         }
         else{
            //there is only one node in the linked list.
            isItemFound = true;
            if(first.getNode().equals(last)){
               node.setNode(null);
               first.setNode(null);
               last.setNode(null);
            }
            //if this is the first node.
            else if(node.equals(first.getNode())){
               Node nextNode = node.getNode();
               first.setNode(nextNode);
               node.setNode(null);
            }
            //if this is the last node.
            else if(node.getNode() == null){
               last.setNode(prevNode);
               prevNode.setNode(null);
            }
            //if this is the middle node
            else{
               prevNode.setNode(node.getNode());
               node.setNode(null);
            }
         }
      }while(node.getNode() != null);

      if(!isItemFound){
         throw new IllegalArgumentException("item : " + item + " not found");
      }
      size --;
   }

   public boolean contains(int item){
      Node node = first.getNode();
      do {
         if(node.getValue() == item){
            return true;
         }
      } while ((node = node.getNode()) != null);
      return false;
   }

   public int indexOf(int item){
      int count  = 0;
      Node node = first.getNode();
      do {
         if(node.getValue() == item){
            return count;
         }
         count ++;
      } while ((node = node.getNode()) != null);
      return -1;
   }

   public void print(){
      if(size <= 0)
         return ;
      Node node = first.getNode();
      do {
         System.out.println(node.getValue());
      }while((node = node.getNode()) != null);
   }

   public void reverse(){

      Node next = first.getNode();
      Node prev = null;
      Node current = null;
      while(next != null){
         prev = current;
         current = next;
         next = next.getNode();
         if(prev == null){
            last.setNode(current);
         }
         current.setNode(prev);
      }
      first.setNode(current);
   }

   public int getSize(){
      return size;
   }

   public int getKNodeFromEnd(int k){
      if(k <= 0)
         throw new IllegalArgumentException();

      Node current = first.getNode();
      Node prev = current;
      int count = 0;
      int index = 0;
      while (current != null){
         if(count > (k - 1)){
            prev = prev.getNode();
         }
         else{
            count ++;
         }
         current = current.getNode();
         index ++;
      }
      if (k > index){
         throw new IllegalArgumentException();
      }
      return prev.getValue();
   }
}
