package algoexpert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayPermutations {

   public List<Integer[]> getAllPermutations(Integer[] input){
      List<Integer[]> permutations = new ArrayList<>();
      getPermutations(0, input, permutations);
      return permutations;
   }

    private void getPermutations(int idx, Integer[] input, List<Integer[]> permutations) {
       if(idx == input.length - 1)
           permutations.add(Arrays.copyOf(input, input.length));
       else{
           for(int j = idx; j < input.length; j ++){
               swap(idx, j, input);
               getPermutations(idx + 1, input, permutations);
               swap(idx, j, input);
           }
       }
    }

    private void swap(int i, int j, Integer[] input){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
      ArrayPermutations obj = new ArrayPermutations();
      final List<Integer[]> allPermutations = obj.getAllPermutations(new Integer[]{ 1, 2, 3,4 });
      for(Integer[] permutation : allPermutations){
         System.out.println(Arrays.toString(permutation));
      }
   }
}
