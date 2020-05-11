package dynamicprogramming;

public class CoinDenomination {

   public int getTotalWays(int[] denominations, int totalAmount){

      int[] totalWays = new int[totalAmount + 1];

      //base condition
      totalWays[0] = 1;

      for(int coin : denominations)
         getWays(coin, totalAmount, totalWays);

      return 0;
   }

   private void getWays(int coin, int totalAmount, int[] totalWays) {
      for(int i = 1; i <= totalAmount; i ++){
         if(totalAmount >= coin)
            totalWays[totalAmount] = 1 + totalWays[totalAmount]
      }
   }

   public static void main(String[] args) {
      CoinDenomination obj = new CoinDenomination();
      int[] denominations = {1,2,5,10,25};
      int totalAmount = 10;
      System.out.print(obj.getTotalWays(denominations, totalAmount));
   }

}
