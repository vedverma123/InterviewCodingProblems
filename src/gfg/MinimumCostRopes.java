package gfg;

import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/connect-n-ropes-minimum-cost/
//O(nlogn) - time, where O(logn) is the priority queue insert and remove operations.
//O(n) - space.
public class MinimumCostRopes {
    long minCost(long arr[]) {
        if(arr == null || arr.length == 0)
            return 0;
        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        for(long item : arr)
            queue.add(item);

        long minCost = 0;
        while(queue.size() > 1){
            long cost = queue.remove() + queue.remove();
            minCost += cost;
            queue.add(cost);
        }

        return minCost;
    }

    public static void main(String[] args){
        MinimumCostRopes obj = new MinimumCostRopes();
        System.out.println(obj.minCost(new long[]{4,3,2,6}));
    }
}
