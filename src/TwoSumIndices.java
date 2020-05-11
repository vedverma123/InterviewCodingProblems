import java.util.HashMap;
import java.util.Map;

public class TwoSumIndices {
   public int[] twoSum(int[] nums, int target) {
      Map<Integer, Integer> map = new HashMap<>();
      int[] output = new int[2];
      for (int i = 0; i <= nums.length -1 ; i ++){
         map.put(nums[i], i);
      }

      for (int i = 0; i <= nums.length - 1; i ++){
         if(map.containsKey(target - nums[i]) && i != map.get(target - nums[i])){
            output[1] = i;
            output[0] = map.get(target - nums[i]);
         }
      }

      return output;
   }

   public static void main(String[] args) {
      TwoSumIndices obj = new TwoSumIndices();
      int[] indices = obj.twoSum(new int[]{3,2,4}, 6);

      for (int i : indices){
         System.out.println(i);
      }
   }
}
