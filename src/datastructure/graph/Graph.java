package datastructure.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Graph {

   public class Node{
      private String label;

      public String getLabel() {
         return label;
      }

      public Node(String label) {
         this.label = label;
      }

      @Override
      public String toString() {
         return label;
      }
   }

   public Map<String, Node> nodes = new HashMap<>();
   public Map<Node, List<Node>> adjacencyList = new HashMap<>();

   public void addNode(String label){
      Node node = new Node(label);
      nodes.putIfAbsent(label,node);
      adjacencyList.putIfAbsent(node, new ArrayList<>());
   }

   public boolean areNodesValid(String label1, String label2){
      Node fromNode = nodes.get(label1);
      Node toNode = nodes.get(label2);
      if(fromNode == null || toNode == null)
         throw new IllegalArgumentException();

      return true;
   }

   public boolean isNodeConnected(String from, String to){
      if(areNodesValid(from, to))
         return adjacencyList.get(nodes.get(from)).contains(nodes.get(to));
      return false;
   }

   public void removeNode(String label){
      if(label == null)
         return;

      Node node = nodes.get(label);
      if(node == null)
         return;

      for(Node key : adjacencyList.keySet())
         adjacencyList.get(key).remove(node);

      adjacencyList.remove(node);
      this.nodes.remove(label);
   }

   public void addEdge(String from, String to){
      if(areNodesValid(from, to))
         adjacencyList.get(nodes.get(from)).add(nodes.get(to));

   }

   public void removeEdge(String from, String to){
      if(areNodesValid(from, to))
         adjacencyList.get(nodes.get(from)).remove(nodes.get(to));
   }

   public void print(){
      final Set<Map.Entry<Node, List<Node>>> entries = this.adjacencyList.entrySet();
      for(Map.Entry<Node, List<Node>> entry : entries)
         if(entry.getValue().size() != 0)
            System.out.println(entry.getKey().label + " is connected to " + Arrays.toString(entry.getValue().toArray()));
         else
            System.out.println(entry.getKey().label + " is not connected to any node.");

   }

   public void traverseDepthFirst(String label){
      Node node = nodes.get(label);
      if(node == null)
         return;

      Set<Node> traversedNodes = new HashSet<>();
      traverseDepthFirst(node, traversedNodes);

   }

   private void traverseDepthFirst(Node node, Set<Node> traversedNodes) {
      if(traversedNodes.contains(node))
         return;
      traversedNodes.add(node);
      System.out.println(node.label);

      final List<Node> neighbouringNodes = adjacencyList.get(node);
      for(Node neighbour : neighbouringNodes){
         traverseDepthFirst(neighbour, traversedNodes);
      }
   }

   public void traverseDepthFirst_Iterative(String label){
      Node node = nodes.get(label);
      if(node == null)
         return;

      Stack<Node> stack = new Stack<>();
      Set<Node> visitedNodes = new HashSet<>();
      stack.push(node);
      while(!stack.isEmpty()){
         Node currentNode = stack.pop();

         if(visitedNodes.contains(currentNode))
            continue;

         visitedNodes.add(currentNode);
         System.out.println(currentNode);

         for(Node neighbourNode : adjacencyList.get(currentNode))
            if(!visitedNodes.contains(neighbourNode))
               stack.push(neighbourNode);

      }
   }

   public void traverseBreadthFirst(String label){
      Node node = nodes.get(label);
      if(node == null)
         return;

      Queue<Node> queue = new ArrayDeque<>();
      Set<Node> visitedNodes = new HashSet<>();

      queue.add(node);
      while(!queue.isEmpty()){
         Node current = queue.remove();

         if(visitedNodes.contains(current))
            continue;

         visitedNodes.add(current);
         System.out.println(current);
         for(Node neighbour : adjacencyList.get(current)){
            if(!visitedNodes.contains(neighbour))
               queue.add(neighbour);
         }
      }
   }

   public List<String> topologicalSort(){
      Stack<Node> stack = new Stack<>();
      Set<Node> visitedNodes = new HashSet<>();
      for(Node node : nodes.values())
         topologicalSort(node, visitedNodes, stack);
      List<String> list = new ArrayList<>();
      while (!stack.isEmpty())
         list.add(stack.pop().label);
      return list;
   }

   private void topologicalSort(Node node, Set<Node> visitedNodes, Stack<Node> stack) {
      if(visitedNodes.contains(node))
         return;

      visitedNodes.add(node);
      for(Node neighbour : adjacencyList.get(node)){
         if(!visitedNodes.contains(neighbour))
            topologicalSort(neighbour, visitedNodes, stack);
      }

      stack.push(node);
   }

   public boolean hasCycle(){
      Set<Node> all = new HashSet<>();
      Set<Node> visiting = new HashSet<>();
      Set<Node> visited = new HashSet<>();

      all.addAll(nodes.values());

      while(!all.isEmpty()){
         Node current = all.iterator().next();
         if(hasCycle(current, all, visiting, visited))
            return true;
      }
      return false;
   }

   private boolean hasCycle(Node root, Set<Node> all, Set<Node> visiting, Set<Node> visited){
      all.remove(root);
      visiting.add(root);

      for(Node neighbour : adjacencyList.get(root)){
         if(visited.contains(neighbour))
            continue;

         if(visiting.contains(neighbour))
            return true;

         if(hasCycle(neighbour, all, visiting, visited))
            return true;
      }

      visiting.remove(root);
      visited.add(root);
      return false;
   }


   public static void main(String[] args) {
      Graph graph = new Graph();
      graph.addNode("A");
      graph.addNode("B");
      graph.addNode("C");
      graph.addNode("D");
      graph.addNode("E");
      graph.addEdge("B", "D");
      graph.addEdge("B", "C");
      graph.addEdge("A", "B");
      graph.addEdge("A", "C");
      graph.addEdge("A", "D");
      graph.addEdge("C", "D");
      graph.addEdge("D", "E");
      graph.addEdge("E", "A");
      graph.print();

//      datastructure.array.graph.removeEdge("A","D");
//      datastructure.array.graph.removeNode("D");
//      System.out.println("<---------------------After removing Node D-------------->");

//      datastructure.array.graph.print();
      System.out.println("<---------------------Depth First Traversal using Recursion-------------->");
      graph.traverseDepthFirst("B");

      System.out.println("<---------------------Depth First Traversal using Iteration-------------->");
      graph.traverseDepthFirst_Iterative("B");

      System.out.println("<---------------------Breadth First Traversal using Iteration-------------->");
      graph.traverseBreadthFirst("B");


      System.out.println("<---------------------Topological sort-------------->");
      System.out.println();
      System.out.println();
      System.out.println();

      Graph graph1 = new Graph();
      graph1.addNode("P");
      graph1.addNode("A");
      graph1.addNode("B");
      graph1.addNode("C");
      graph1.addNode("D");
      graph1.addNode("X");

      graph1.addEdge("X", "C");
      graph1.addEdge("X", "D");
      graph1.addEdge("C", "D");
      graph1.addEdge("C", "A");
      graph1.addEdge("A", "P");
      graph1.addEdge("D", "B");
      graph1.addEdge("B", "P");

//      System.out.println(graph1.topologicalSort().toString());


      System.out.println(graph.hasCycle());
   }
}