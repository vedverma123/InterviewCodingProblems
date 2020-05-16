package dynamicprogramming;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 */
public class BuyAndSellStock {

   //Find max profit in a single transaction ONLY.
   public int maxProfit(int[] price){

      if(price == null || price.length == 0)
         return 0;

      int maxProfit = 0;
      int minPrice = Integer.MAX_VALUE;
      for(int i = 0; i < price.length; i ++){

         if(minPrice > price[i])
            minPrice = price[i];

         else if(price[i] - minPrice > maxProfit)
            maxProfit = price[i] - minPrice;

      }

      return maxProfit;
   }

   public static void main(String[] args) {
      BuyAndSellStock obj = new BuyAndSellStock();
      int[] price = {7,1,5,3,6,4};
      System.out.print(obj.maxProfit(price));
   }

}
