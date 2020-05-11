package string;

public class StringReverse {
   public void reverseString(char[] s) {
      char temp;
      for(int start = 0, end = s.length - 1; start <= end ; start ++, end --){
         temp = s[start];
         s[start] = s[end];
         s[end] = temp;
      }
   }

   public static void main(String[] args) {
      StringReverse stringReverse = new StringReverse();
      char[] string = new char[]{'h','e','l','l', 'o'};
      System.out.println("Before reverse--->");
      for (char c : string){
         System.out.print(c);
      }
      stringReverse.reverseString(string);
      System.out.println("After reverse--->");
      for (char c : string){
         System.out.print(c);
      }

   }
}
