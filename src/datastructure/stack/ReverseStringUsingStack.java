package datastructure.stack;

import java.util.Stack;

public class ReverseStringUsingStack {

   public String reverse(String string){
      if(string == null)
         throw new IllegalArgumentException();
      Stack<Character> stack = new Stack<>();
      for (char c : string.toCharArray()){
         stack.push(c);
      }
      StringBuffer reversed = new StringBuffer();
      while(!stack.empty()){
         reversed.append(stack.pop());

      }
      return reversed.toString();
   }

   public static void main(String[] args) {
      String input = "Hell%^&*";
      System.out.println("Before reverse : " + input);
      System.out.println("After reverse : " + new ReverseStringUsingStack().reverse(input));
   }
}
