package algoexpert;

import datastructure.array.Array;
import datastructure.graph.Graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DepthFirstSearch {


   //Time complexity - O(V + E)
   // Space complexity - O(V)
   public String[] search(Graph graph){
      Set<Graph.Node> visitedNodes = new LinkedHashSet<>();
      for(Graph.Node node : graph.nodes.values()){
         search(visitedNodes, node, graph);
      }
      String[] labels = new String[visitedNodes.size()];
      int count = 0;
      for(Graph.Node node : visitedNodes)
         labels[count ++] = node.getLabel();
      return labels;
   }

   private void search(Set<Graph.Node> visitedNodes, Graph.Node node, Graph graph) {
      if(visitedNodes.contains(node))
         return;
      visitedNodes.add(node);
      List<Graph.Node> neighboures = graph.adjacencyList.get(node);
      for(Graph.Node neighbour : neighboures){
         if(visitedNodes.contains(neighbour))
            continue;
         search(visitedNodes, neighbour, graph);
      }
   }

   public static void main(String[] args) {
      Graph graph = new Graph();
      graph.addNode("A");
      graph.addNode("B");
      graph.addNode("C");
      graph.addNode("D");
      graph.addNode("E");
      graph.addNode("F");
      graph.addNode("G");
      graph.addNode("H");
      graph.addNode("I");
      graph.addNode("J");
      graph.addNode("K");

      graph.addEdge("A","B");
      graph.addEdge("A","C");
      graph.addEdge("A","D");

      graph.addEdge("B","E");
      graph.addEdge("B","F");

      graph.addEdge("F","I");
      graph.addEdge("F","J");

      graph.addEdge("D","G");
      graph.addEdge("D","H");

      graph.addEdge("G","K");

      DepthFirstSearch obj = new DepthFirstSearch();
      System.out.println(Arrays.toString(obj.search(graph)));
   }

}
