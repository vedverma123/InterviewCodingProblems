package datastructure.tree;

public class Tree {

   public Node root;

   public void insert(int value){
      Node node = createNode(value, null, null);
      if(root == null){
         root = node;
         return;
      }
      Node targetNode = findNode(value);
      if(targetNode.value > value)
         targetNode.left = node;
      else if(targetNode.value < value)
         targetNode.right = node;
   }

   public Node createNode(int value, Node left, Node right) {
      return new Node(value, left, right);
   }

   public boolean find(int value){
      Node targetNode = findNode(value);
      return targetNode != null && targetNode.value == value;
   }

   private Node findNode(int value){
      Node currentNode, prevNode ;
      currentNode = prevNode = root;
      while(currentNode != null){
         prevNode = currentNode;
         if(value > currentNode.value)
            currentNode = currentNode.right;

         else if(value < currentNode.value)
            currentNode = currentNode.left;

         else
            return prevNode;
      }
      return prevNode;
   }

   public int min(){
      return min(root);
   }

   public int min(Node root){
      if(isLeaf(root))
         return root.value;

      return Math.min(root.value, Math.min(min(root.left), min(root.right)));
   }

   public boolean isLeaf(Node node){
      return node.right == null && node.left == null;
   }

   public int height(){
      return height(root);
   }

   private int height(Node root) {
      if(root== null)
         return -1;

      if(isLeaf(root))
         return 0;

      return 1 + Math.max(height(root.left), height(root.right));
   }

   public boolean equals(Tree other){
      return equals(root, other.root);
   }

   public void swapRoot(){
      final Node temp = root.left;
      root.left = root.right;
      root.right = temp;
   }

   private boolean equals(Node first, Node second) {
      if(first == null && second == null)
         return true;
      if(first != null && second != null){
         return first.value == second.value && equals(first.left, second.left) && equals(first.right, second.right);
      }
      return false;
   }

   private boolean validateBST(Node root, int min, int max){
      if(root == null)
         return true;
      if(min < root.value && max > root.value){
         return validateBST(root.left, min, root.value) && validateBST(root.right, root.value, max);
      }
      return false;
   }

   public boolean validateBST(){
      return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
   }
   
   public void KthNodeFromRoot(int k){
      KthNodeFromRoot(k, root);
   }

   private void KthNodeFromRoot(int k, Node root) {
      if(root == null){
         throw new IllegalArgumentException();
      }
      if(k==0 ){
         System.out.println(root.value);
         return;
      }

      KthNodeFromRoot(k-1, root.left);
      KthNodeFromRoot(k-1, root.right);
   }

   public void traverseLevelOrder(){
      for(int i = 0; i <= height(root); i ++){
         KthNodeFromRoot(i);
      }
   }

   public void removeNode(int item){
      if(root.value == item){
         //remove root and find out the smallest value in right subtree to create a root.
         Node newRoot = findSmallestNodeInRightSubtree(root.right);
         newRoot.right = root.right;
         newRoot.left = root.left;
         root = newRoot;
         return;
      }

      Node current = root, prev = root;
      while(current != null){
         //got the target node.
         if(current.value == item){
            root = removeNode(current, prev);
            break;
         }
         prev = current;
         if(current.value > item)
            current = current.left;
         else
            current = current.right;
      }
   }

   private Node removeNode(Node current, Node prev) {
      boolean isRight = current.value > prev.value ? true : false;

      if(current.left == null && current.right == null)
         if(isRight)
            prev.right = null;
         else
            prev.left = null;

      else if(current.left == null && current.right != null)
         if(isRight)
            prev.right = current.right;
         else
            prev.left = current.right;

      else if(current.left != null && current.right == null)
         if(isRight)
            prev.right = current.left;
         else
            prev.left = current.left;

      //both nodes are non null
      else{
         Node smallest = findSmallestNodeInRightSubtree(current.right);
         smallest.left = current.left;
         if(isRight)
            prev.right = smallest;
         else
            prev.left = smallest;
      }
      return root;
   }

   private Node findSmallestNodeInRightSubtree(Node right) {
      Node current = right, prev = null;
      while(current.left != null){
         prev = current;
         current = current.left;
      }
      Node smallest = current;
      if(prev != null)
         prev.left = null;
      return smallest;
   }

   public static void main(String[] args) {
      Tree tree = new Tree();
      tree.insert(10);
      tree.insert(12);
      tree.insert(11);
      tree.insert(8);
      tree.insert(5);
      tree.insert(15);
      tree.insert(9);
      tree.insert(6);

      tree.removeNode(12);

/*
      System.out.println(tree.find(11));
      System.out.println(tree.find(9));
      System.out.println(tree.find(19));
      System.out.println(tree.find(10));
      System.out.println(tree.height());
*/
//      System.out.println(tree.min());

/*
      Tree tree2 = new Tree();
      tree2.insert(10);
      tree2.insert(22);
      tree2.insert(11);
      tree2.insert(8);
      tree2.insert(5);
      tree2.insert(15);
      tree2.insert(9);
*/

//      System.out.println(tree.equals(tree2));
//      tree.swapRoot();
//      System.out.println(tree.validateBST());
//      tree.KthNodeFromRoot(3);

      //      System.out.println();
      tree.traverseLevelOrder();


   }
}
