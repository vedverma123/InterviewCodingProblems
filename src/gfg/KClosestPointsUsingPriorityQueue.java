package gfg;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given a list of n points on 2D plane, the task is to find the K (k < n) closest points to the origin O(0, 0).
 *
 * Note: The distance between a point P(x, y) and O(0, 0) using the standard Euclidean Distance.
 *
 * Input: [(1, 0), (2, 1), (3, 6), (-5, 2), (1, -4)], K = 3
 * Output: [(1, 0), (2, 1), (1, -4)]
 * Explanation:
 * Square of Distances of points from origin are
 * (1, 0) : 1
 * (2, 1) : 5
 * (3, 6) : 45
 * (-5, 2) : 29
 * (1, -4) : 17
 * Hence for K = 3, the closest 3 points are (1, 0), (2, 1) & (1, -4).
 */
public class KClosestPointsUsingPriorityQueue {
   private class Point{
      int x,y;

      public Point(int x, int y) {
         this.x = x;
         this.y = y;
      }
   }

   private class PointComparator implements Comparator<Point>{
      private Point origin = new Point(0,0);
      @Override
      public int compare(Point p1, Point p2) {
         double d1 = getEuclideanDistance(p1);
         double d2 = getEuclideanDistance(p2);
         if(d1 == d2)
            return 0;
         return d1 < d2 ? -1 : 1;
      }

      private double getEuclideanDistance(Point p){
         return Math.sqrt(Math.pow(p.x - 0, 2)+Math.pow(p.y - 0, 2));
      }
   }

   private List<Point> getKClosestPoints(int[][] points, int k) {
      List<Point> closest = new ArrayList<>();
      if(points == null || points.length == 0 || k < 1)
         return closest;

      PriorityQueue<Point> queue = new PriorityQueue<>(points.length,new PointComparator());
      for (int[] coordinates : points){
         Point point = new Point(coordinates[0], coordinates[1]);
         queue.add(point);
      }

      while(k > 0 && !queue.isEmpty()){
         closest.add(queue.remove());
         k --;
      }

      return closest;
   }

   public static void main(String[] args) {
      KClosestPointsUsingPriorityQueue obj = new KClosestPointsUsingPriorityQueue();
      int[][] points = {{1,0},{2,1},{3,6},{-5,2},{1,-4}};
      int k = 3;
      List<Point> closestPoints = obj.getKClosestPoints(points, k);
      for (Point closestPoint : closestPoints)
         System.out.println("("+closestPoint.x +", "+ closestPoint.y+")");
   }

}
