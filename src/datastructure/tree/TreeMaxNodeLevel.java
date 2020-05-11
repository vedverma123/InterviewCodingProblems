package datastructure.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;



class TreeMaxNodeLevel {

   static class Node{
      int data;
      Node left;
      Node right;
      Node(int data){
         this.data = data;
         left=null;
         right=null;
      }
   }

   static Node buildTree(String str){

      if(str.length()==0 || str.charAt(0)=='N'){
         return null;
      }

      String ip[] = str.split(" ");
      // Create the root of the datastructure.array.tree
      Node root = new Node(Integer.parseInt(ip[0]));
      // Push the root to the datastructure.array.queue

      Queue<Node> queue = new LinkedList<>();

      queue.add(root);
      // Starting from the second element

      int i = 1;
      while(queue.size()>0 && i < ip.length) {

         // Get and remove the front of the datastructure.array.queue
         Node currNode = queue.peek();
         queue.remove();

         // Get the current node's value from the string
         String currVal = ip[i];

         // If the left child is not null
         if(!currVal.equals("N")) {

            // Create the left child for the current node
            currNode.left = new Node(Integer.parseInt(currVal));
            // Push it to the datastructure.array.queue
            queue.add(currNode.left);
         }

         // For the right child
         i++;
         if(i >= ip.length)
            break;

         currVal = ip[i];

         // If the right child is not null
         if(!currVal.equals("N")) {

            // Create the right child for the current node
            currNode.right = new Node(Integer.parseInt(currVal));

            // Push it to the datastructure.array.queue
            queue.add(currNode.right);
         }
         i++;
      }

      return root;
   }
   static void printInorder(Node root)
   {
      if(root == null)
         return;

      printInorder(root.left);
      System.out.print(root.data+" ");

      printInorder(root.right);
   }

   public static void main (String[] args) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int t=Integer.parseInt(br.readLine());

      while(t > 0){
         String s = br.readLine();
         Node root = buildTree(s);
         TreeMaxNodeLevel g = new TreeMaxNodeLevel();
         int ans = g.maxNodeLevel(root);
         System.out.println(ans);
         t--;

      }
   }

   private int maxNodeLevel(Node root) {
      Node left = root.left, right = root.right;
      int sum = 0, levelcount = 0;
      while(left != null || right != null){
         if(left == null || right == null)
            return levelcount;
         int newSum =  getMaxNodeLevel(left) + getMaxNodeLevel(right);
         if(newSum > sum){
            levelcount++;
         }
         if(left != null)
            left = left.left;
         if(right != null)
            right = right.right;
      }
      return levelcount;
   }

   private int getMaxNodeLevel(Node node){
      return node != null ? 1 : 0;
   }
}
