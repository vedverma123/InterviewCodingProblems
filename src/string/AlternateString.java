package string;

import java.util.Arrays;

public class AlternateString {

   public String generateString(int A, int B){

      char[] chars = new char[A + B];
      if(A == B){
         for(int i = 0; i < A + B; i = i +2)
            chars[i] = 'a';
         for(int i = 1; i < A + B; i = i +2)
            chars[i] = 'b';
      }
      else if(A > B){
         for(int i = 0; i < A + B; i ++)
            chars[i] = 'a';
         int count  = 1;
         for(int i = 2;i < A+B && count <= B; i = i + 3, count ++)
            chars[i] = 'b';
      }
      else{
         for(int i = 0; i < B + A; i ++)
            chars[i] = 'b';
         int count  = 1;
         for(int i = 2; i < A+B && count <= A ; i = i + 3, count ++)
            chars[i] = 'a';
      }
      return Arrays.toString(chars);
   }

   public static void main(String[] args) {
      AlternateString obj = new AlternateString();
      System.out.print(obj.generateString(3,9));
   }
}
