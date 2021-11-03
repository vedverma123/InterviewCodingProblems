package algoexpert;

public class StringInterweaving {

   public boolean isInterweave(String s1, String s2, String s3) {
      if(s3 == null || s3 == "")
         return true;

      int firstString = s1.length();
      int secondString = s2.length();
      if(firstString + secondString != s3.length())
         return false;

      Boolean[][] cache = new Boolean[firstString + 1][secondString + 1];
      return isInterwoven(s1, s2, s3, 0, 0, cache);
   }

   private Boolean isInterwoven(String s1, String s2, String s3, int i, int j, Boolean[][] cache) {
      if(cache[i][j] != null){
         System.out.println("cache hit");
         return cache[i][j];
      }

      int k = i + j;

      if(k == s3.length())
         return Boolean.TRUE;

      if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
         cache[i][j] = isInterwoven(s1, s2, s3, i + 1, j, cache);
         if(cache[i][j])
            return Boolean.TRUE;
      }
      if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
         cache[i][j] = isInterwoven(s1, s2, s3, i, j + 1, cache);
         return cache[i][j];
      }
      cache[i][j] = Boolean.FALSE;
      return Boolean.FALSE;
   }

   public static void main(String[] args) {
      System.out.println(new StringInterweaving().isInterweave("aaa", "aaaf", "aaafaaa"));
   }

}
