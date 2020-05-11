package dynamicprogramming;

public class CoinDenomination {

   //Time complexity - O(n*d) - where n is total amount and d is denominations
   //Space complexity - O(n)
   public int getTotalWays(int[] denominations, int totalAmount){

      int[] totalWays = new int[totalAmount + 1];

      //base condition
      totalWays[0] = 1;

      for(int coin : denominations)
         getWays(coin, totalAmount, totalWays);

      return totalWays[totalAmount];
   }

   private void getWays(int coin, int totalAmount, int[] totalWays) {
      for(int i = 1; i <= totalAmount; i ++){
         if(i >= coin)
            totalWays[i] += totalWays[i-coin];
      }
   }

   public static void main(String[] args) {
      CoinDenomination obj = new CoinDenomination();
      int[] denominations = {1,5,10,25};
      int totalAmount = 10;
      System.out.print(obj.getTotalWays(denominations, totalAmount));
   }

}
