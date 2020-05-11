package datastructure.stack;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BalancedExpressionUsingStack {

   public boolean isExpressionValid(String input){
      Stack<Character> stack = new Stack<>();
      List<Character> leftBrackets = Arrays.asList('(','[','{','<');
      List<Character> rightBrackets = Arrays.asList(')',']','}','>');
      for(char c : input.toCharArray()){
         if(leftBrackets.contains(c)){
            stack.push(c);
         }
         else if( rightBrackets.contains(c)){
            if(stack.empty()){
               return false;
            }
            if(!checkIfvalidChar(c, stack.pop()))
               return false;
         }
      }
      return stack.empty();
   }

   private boolean checkIfvalidChar(char c, char pop) {
      boolean isValidChar = false;
      if(c ==')' && pop == '(')
         isValidChar = true;

      else if(c==']' && pop =='[')
         isValidChar = true;

      else if(c=='}'&& pop =='{')
         isValidChar = true;

      else if(c=='>'&& pop =='<')
         isValidChar = true;

      return isValidChar;
   }

   public static void main(String[] args) {
      String input = "()";
      System.out.println("Is expression : " + input + "  valid : " + new BalancedExpressionUsingStack().isExpressionValid(input));
   }
}
