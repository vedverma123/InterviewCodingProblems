package datastructure.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

public class WeightedGraph {

   private Map<String, Node> nodes = new HashMap<>();

   private class Node{
      private String label;
      private List<Edge> edges;

      public Node(String label) {
         this.label = label;
         edges = new ArrayList<>();
      }

      @Override
      public String toString() {
         return label;
      }

      public void addEdge(Node to, int weight){
         edges.add(new Edge(this, to, weight));
      }

      public List<Edge> getEdges(){
         return edges;
      }
   }

   private class NodeEntry{
      private Node node;
      private int priority;

      public NodeEntry(Node node, int priority) {
         this.node = node;
         this.priority = priority;
      }
   }

   private class Edge{
      Node from;
      Node to;
      int weight;

      public Edge(Node from, Node to, int weight) {
         this.from = from;
         this.to = to;
         this.weight = weight;
      }

      @Override
      public String toString() {
         return from +" -> " + to;
      }
   }

   public void addNode(String label){
      nodes.putIfAbsent(label, new Node(label));
   }

   public void addEdge(String from , String to, int weight){
      Node fromNode = nodes.get(from);
      if(fromNode == null)
         throw new IllegalArgumentException();

      Node toNode = nodes.get(to);
      if(toNode == null){
         throw new IllegalArgumentException();
      }

      fromNode.addEdge(toNode, weight);
      toNode.addEdge(fromNode, weight);
   }

   public void print(){
      for(Node node : nodes.values())
         System.out.println(node + " is connected to " + node.edges);
   }

   public Stack<Node> getShortestDistance(String from, String to){
      Node fromNode = nodes.get(from);
      Node toNode = nodes.get(to);

      if(fromNode == null || toNode == null)
         throw new IllegalArgumentException();

      Map<Node, Integer> nodeDistanceMap = new HashMap<>();
      Map<Node, Node> nodeParentMap = new HashMap<>();
      Set<Node> visited = new HashSet<>();

      for(Node node : nodes.values())
         nodeDistanceMap.put(node, Integer.MAX_VALUE);
      nodeDistanceMap.replace(fromNode, 0);

      PriorityQueue<NodeEntry> queue = new PriorityQueue<>(Comparator.comparing(ne -> ne.priority));
      queue.add(new NodeEntry(fromNode, 0));

      while(!queue.isEmpty()){
         Node current = queue.remove().node;

         for(Edge edge : current.getEdges()){
            if(visited.contains(edge.to))
               continue;

            int newDistance = nodeDistanceMap.get(current) + edge.weight;
            if(newDistance < nodeDistanceMap.get(edge.to)){
               nodeDistanceMap.replace(edge.to, newDistance);
               nodeParentMap.put(edge.to, edge.from);
               queue.add(new NodeEntry(edge.to, newDistance));
            }
         }
         visited.add(current);
      }

      Stack<Node> shortestPath = new Stack<>();
      shortestPath.push(toNode);
      Node parent = nodeParentMap.get(toNode);
      while(parent != null){
         shortestPath.push(parent);
         parent = nodeParentMap.get(parent);
      }
      return shortestPath;
   }

   public boolean hasCycle(){
      Set<Node> all = new HashSet<>(nodes.values());
      Set<Node> visited = new HashSet<>();
      while(!all.isEmpty()){
         Node current = all.iterator().next();
         if(hasCycle(current, null, visited, all))
            return true;
      }
      return false;
   }

   private boolean hasCycle(Node current, Node parent, Set<Node> visited, Set<Node> all) {
      all.remove(current);
      visited.add(current);

      for(Edge edge : current.getEdges()){
         if(edge.to.equals(parent))
            continue;
         if(visited.contains(edge.to))
            return true;
         if(hasCycle(edge.to, current, visited, all))
            return true;
      }
      return false;
   }


   public List<Edge> getMinSpanningTree(){
      PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparing(e -> e.weight));
      Set<Node> visited = new HashSet<>();
      List<Edge> minSpanningTree = new ArrayList<>();

      for(Node node : nodes.values()){
         if(visited.contains(node))
            continue;
         queue.addAll(node.getEdges());
         getMinSpanningTree(node, visited, minSpanningTree, queue);
      }
      return minSpanningTree;
   }

   private void getMinSpanningTree(Node current, Set<Node> visited, List<Edge> minSpanningTree, PriorityQueue<Edge> queue) {
      while(!queue.isEmpty()){
         visited.add(current);
         Edge minEdge = queue.remove();
         if(visited.contains(minEdge.to))
            continue;

         minSpanningTree.add(minEdge);
         for(Edge edge : minEdge.to.getEdges())
            if(!visited.contains(edge.to))
               queue.add(edge);
         getMinSpanningTree(minEdge.to, visited, minSpanningTree, queue);
      }
   }

   public static void main(String[] args) {
      WeightedGraph graph = new WeightedGraph();
      graph.addNode("A");
      graph.addNode("B");
      graph.addNode("C");
      graph.addNode("D");
      graph.addNode("E");
      graph.addNode("F");
      graph.addNode("G");
      graph.addNode("H");

      graph.addEdge("A", "B", 1);
      graph.addEdge("B", "C", 1);
      graph.addEdge("A", "C", 2);
      graph.addEdge("C", "D", 2);
      graph.addEdge("C", "E", 5);
      graph.addEdge("C", "F", 4);
      graph.addEdge("C", "G", 2);
      graph.addEdge("D", "E", 2);
      graph.addEdge("D", "H", 8);
      graph.addEdge("E", "F", 1);
      graph.addEdge("F", "H", 1);
      graph.addEdge("G", "H", 5);

      graph.print();
      Stack<Node> path = graph.getShortestDistance("B", "H");
      while(!path.isEmpty())
         System.out.println(path.pop());


      WeightedGraph graph1 = new WeightedGraph();
      graph1.addNode("A");
      graph1.addNode("B");
      graph1.addNode("C");
      graph1.addNode("D");
      graph1.addNode("E");

      graph1.addEdge("A", "B", 1);
      graph1.addEdge("B", "C", 1);
      graph1.addEdge("C", "D", 1);
      graph1.addEdge("D", "E", 1);
      graph1.addEdge("D", "B", 1);
//      graph1.addEdge("C", "E", 1);

      System.out.println("HAS CYCLE ---------- > "+graph1.hasCycle());

      WeightedGraph graph2 = new WeightedGraph();
      graph2.addNode("A");
      graph2.addNode("B");
      graph2.addNode("C");
      graph2.addNode("D");

      graph2.addEdge("A", "B", 1);
//      graph2.addEdge("A", "C", 1);
      graph2.addEdge("B", "C", 2);
      graph2.addEdge("A", "D", 5);
      graph2.addEdge("C", "D", 3);

      List<Edge> minSpanningTree = graph2.getMinSpanningTree();
      int total = 0;
      for(Edge edge : minSpanningTree)
         total += edge.weight;
      System.out.println("total : " + total + ", " + minSpanningTree.toString());



   }
}
