package dynamicprogramming;

/**
 * Given two strings str1 and str2 and below operations that can performed on str1.
 * Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.
 *
 * Insert
 * Remove
 * Replace
 * All of the above operations are of equal cost.
 */
public class LevenshteinDistance {

   //Time complexity - O(m*n)
   //Space Complexity - O(m*n)
   public int minOperations(String str1, String str2){
      if(str1 == null && str2 == null)
         return 0;

      if(str1 == null || str1.trim().length() == 0)
         return str2.length();

      if(str2 == null || str2.trim().length() == 0)
         return str1.length();

      str1 = " "+str1;
      str2 = " "+str2;

      int[][] totalEdits = new int[str1.length()][str2.length()];

      for(int row = 0; row < str1.length(); row ++)
         totalEdits[row][0] = row;

      for(int col = 0; col < str1.length(); col ++)
         totalEdits[0][col] = col;

      for(int row = 1; row < str1.length(); row ++)
         for(int col = 1; col < str2.length(); col ++){

            if(str1.charAt(row) == str2.charAt(col)){
               if(row == 0 && col == 0 )
                  totalEdits[row][col] = 0;
               else
                  totalEdits[row][col] = totalEdits[row - 1][col - 1];
            }

            else
               totalEdits[row][col] = 1 + min(totalEdits[row - 1][col - 1], totalEdits[row][col - 1], totalEdits[row - 1][col]);
         }

      return totalEdits[str1.length() - 1][str2.length() - 1];
   }

   private int min(int diagonal, int lastCol, int lastRow) {
      if(diagonal <= lastRow && diagonal <= lastCol)
         return diagonal;
      else if(lastCol <= diagonal && lastCol <= lastRow)
         return lastCol;
      else
         return lastRow;
   }


   public static void main(String[] args) {
      LevenshteinDistance obj = new LevenshteinDistance();
      System.out.print(obj.minOperations("abc", "yabd"));
   }

}
