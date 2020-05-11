package datastructure.tree;

public class AVLTree {

   private Node root;

   private class Node{
      int value;
      int height;
      Node left;
      Node right;

      public Node(int value) {
         this.value = value;
      }
   }

   public void insert(int item){
      root = insert(root, item);
   }

   public Node insert(Node root, int item){
      if(root == null)
         return new Node(item);
      if(root.value > item)
         root.left = insert(root.left, item);
      else
         root.right = insert(root.right, item);

      root.height = 1 + Math.max(height(root.left), height(root.right));
      root = balance(root);
      return root;
   }

   private void setHeight(Node node){
       node.height = 1 + Math.max(height(node.left), height(node.right));
   }

   private Node balance(Node root) {
      if(balanceFactor(root) > 1){
         if(balanceFactor(root.left) < 0){
            root.left = leftRotate(root.left);
         }
         return rightRotate(root);
      }
      else if(balanceFactor(root) < -1){
         if(balanceFactor(root.right) > 0){
            root.right = rightRotate(root.right);
         }
         return leftRotate(root);
      }
      return root;
   }

   private Node rightRotate(Node root) {
      Node newRoot = root.left;
      root.left = newRoot.right;
      newRoot.right = root;

      setHeight(root);
      setHeight(newRoot);
      return newRoot;
   }

   private Node leftRotate(Node root) {
      Node newRoot = root.right;
      root.right = newRoot.left;
      newRoot.left = root;

      setHeight(root);
      setHeight(newRoot);
      return newRoot;
   }

   private int balanceFactor(Node node){
      return height(node.left) - height(node.right);
   }

   public int height(Node node){
      return node == null ? -1 : node.height;
   }

   public static void main(String[] args) {
      AVLTree tree = new AVLTree();
      tree.insert(5);
      tree.insert(4);
      tree.insert(8);
      tree.insert(7);
      tree.insert(9);
      tree.insert(6);

   }
}
