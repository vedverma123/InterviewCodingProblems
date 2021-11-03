package algoexpert;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TopologicalSort {

    public int[] sort(int[] nums, int[][] dependency){
        if(nums == null || nums.length == 0)
            return new int[0];

        Map<Integer, Set<Integer>> dependencyMap = new HashMap();
        int[] sortedArray = new int[nums.length];

        //O(V)
        for(int num : nums)
            dependencyMap.put(num, new HashSet());

        //O(E)
        for(int[] currentDependency : dependency){
            int dependent = currentDependency[1];
            if(dependencyMap.containsKey(dependent)){
                Set<Integer> set = dependencyMap.get(dependent);
                set.add(currentDependency[0]);
            }
        }

        Set<Integer> visited = new HashSet();
        int count = 0;
        //O(V*E)
        while(!dependencyMap.isEmpty()){

            //get the zero dependency list entry or an entry having all visited values from the map.
            int key = getZeroDependencyOrAllVisisted(dependencyMap, visited);
            dependencyMap.remove(key);
            visited.add(key);
            sortedArray[count ++] = key;
        }

        return sortedArray;
    }

    public int getZeroDependencyOrAllVisisted(Map<Integer, Set<Integer>> dependencyMap, Set<Integer> visisted){
        int key = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Set<Integer>> entry : dependencyMap.entrySet()){
            Set<Integer> values = entry.getValue();
            if(values.size() == 0 || values.equals(visisted)){
                key = entry.getKey();
                break;
            }
        }
        return key;
    }

    public static void main(String[] args) {
        int[] input = {1,2,3,4};
        int[][] dependencies = {{1,2},{1,3},{3,2},{4,2},{4,3}};
        System.out.println(Arrays.toString(new TopologicalSort().sort(input, dependencies)));
    }
}
