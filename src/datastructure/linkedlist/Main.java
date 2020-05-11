package datastructure.linkedlist;

public class Main {
   public static void main(String[] args) {
      LinkedList linkedList = new LinkedList();
      linkedList.addFirst(10);
      linkedList.addLast(20);
      linkedList.addFirst(5);
      linkedList.addLast(30);
      linkedList.addLast(40);
      linkedList.addLast(50);

      System.out.println("-----------------size-----------" + linkedList.getSize());

      System.out.println("-----------------Before remove-----------");
      linkedList.print();

      System.out.println("-----------------after remove-----------");
      linkedList.delete(10);
      linkedList.delete(30);
      linkedList.print();
      System.out.println("-----------------size-----------" + linkedList.getSize());

      System.out.println("-----------------after reverse-----------");
      linkedList.reverse();
      linkedList.print();
      System.out.println("-----------------size-----------" + linkedList.getSize());

      System.out.println("-----------------after remove-----------");
      linkedList.delete(50);
      linkedList.delete(40);
      //linkedList.delete(5);
      linkedList.delete(20);
//      linkedList.deleteFirst();

      linkedList.print();
      System.out.println("-----------------size-----------" + linkedList.getSize());

      int k =2;
      System.out.println("----------------- " + k + "th node-----------" + linkedList.getKNodeFromEnd(k));


   }
}
