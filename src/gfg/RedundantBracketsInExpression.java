package gfg;

import java.util.Stack;

/**
 * Given a string of balanced expression, find if it contains a redundant parenthesis or not.
 * A set of parenthesis are redundant if same sub-expression is surrounded by unnecessary or multiple brackets.
 */
public class RedundantBracketsInExpression {

   //Time complexity - O(n)
   //Space complexity - O(n)
   public boolean checkRedundancy(String expression){
      if(expression == null || expression.length() == 0)
         return false;

      expression = expression.trim();
      int count = 0;
      Stack<Character> stack = new Stack<>();
      while(count < expression.length()){
         char current = expression.charAt(count);

         if(current == ')'){
            char top = stack.pop();

            boolean isOperatorNotFound = true;
            while(top != '('){

               //check for operator
               if(isOperator(top))
                  isOperatorNotFound = false;

               top = stack.pop();
            }
            if(isOperatorNotFound)
               return true;
         }else
            stack.push(current);

         count ++;
      }

      return false;
   }

   private boolean isOperator(char top) {
      return top == '+' || top == '-' || top == '*' || top == '/' || top == '^' || top == '%';
   }

   public static void main(String[] args) {
      RedundantBracketsInExpression obj = new RedundantBracketsInExpression();
      String expression = "a+(b*d)/(c-e) -(a)";
      System.out.print(obj.checkRedundancy(expression));
   }

}
