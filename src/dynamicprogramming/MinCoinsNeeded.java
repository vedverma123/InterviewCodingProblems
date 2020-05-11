package dynamicprogramming;

/**
 * This class solve the problem to get min coins needed to make change of given amount.
 */
public class MinCoinsNeeded {

   //Not sure, but I think less than O(n) + O(d) = O(n)
   public int getMinCoins(int[] denominations, int amount){
      int totalCoins = 0;
      if(amount <= 0)
         return totalCoins;

      totalCoins = getMinCoins(denominations, amount, totalCoins);

      return totalCoins;
   }


   private int getMinCoins(int[] denominations, int amount, int totalCoins){
      int coin = getMaxDenomination(denominations, amount);
      if(coin > 0) {
         totalCoins += amount / coin;
         int remainder = amount % coin;
         while (remainder != 0) {
            return getMinCoins(denominations, remainder, totalCoins);
         }
      }
      return totalCoins;
   }

   // Time complexity - worst case : O(d), where d is denominations.
   private int getMaxDenomination(int[] denominations, int amount) {
      int max = -1;
      for(int coin : denominations)
         if(coin <= amount && coin > max)
            max = coin;
      return max;
   }

   public static void main(String[] args) {
      MinCoinsNeeded obj = new MinCoinsNeeded();
      int[] denominations = {1,2,4};
      int amount = 7;
      System.out.print(obj.getMinCoins(denominations, amount));
   }

}
