package gfg;

import java.util.Stack;

/**
 * Given an Infix expression, convert it into a Prefix expression using two stacks.
 *
 * Infix : An expression is called the Infix expression if the operator appears in between the operands in the expression.
 * Simply of the form (operand1 operator operand2).
 * Example : (A+B) * (C-D)
 *
 * Prefix : An expression is called the prefix expression if the operator appears in the expression before the operands.
 * Simply of the form (operator operand1 operand2).
 * Example : *+AB-CD (Infix : (A+B) * (C-D) )
 */
public class InfixToPrefixExpression {

   //Time Complexity - O(n)
   //Space Complexity - O(n)
   public String convert(String input){
      if(input == null || input.length() == 0)
         return "";

      input = input.trim();

      Stack<Character> operators = new Stack<>();
      Stack<String> operands = new Stack<>();

      int index = 0;
      int size = input.length();

      while(index < size){
         char current = input.charAt(index);

         if (current == '(') {
            operators.push(current);
         }
         else if(isOperand(current)){
            operands.push(current +"");
         }else if (current == ')'){
            while(!operators.isEmpty() && operators.peek() != '('){
               String operand1 = operands.pop();
               String operand2 = operands.pop();
               String temp = operators.pop() + operand2 + operand1;
               operands.push(temp);
            }
            operators.pop();
         }
         //is operator
         else{
            while(!operators.isEmpty() && getPriority(current) <= getPriority(operators.peek())){
               String operand1 = operands.pop();
               String operand2 = operands.pop();
               String temp = operators.pop() + operand2 + operand1;
               operands.push(temp);
            }

            operators.push(current);
         }
         index ++;
      }

      while(!operators.isEmpty()){
         String operand1 = operands.pop();
         String operand2 = operands.pop();
         String temp = operators.pop() + operand2 + operand1;
         operands.push(temp);
      }

      return operands.pop();
   }

   // Function to find priority of given operator.
   private int getPriority(char ch)
   {
      if (ch == '-' || ch == '+')
         return 1;
      else if (ch == '*' || ch == '/')
         return 2;
      else if (ch == '^')
         return 3;
      return 0;
   }
   private boolean isOperand(char current) {
      return (current >= 'A' && current <= 'Z') ||
             (current >= 'a' && current <= 'z') ||
             (current >= '0' && current <= '9');
   }

   public static void main(String[] args) {
      InfixToPrefixExpression obj = new InfixToPrefixExpression();
      String expression = "(A-B/C)*(A/K-L)";
      System.out.print(obj.convert(expression));
   }

}
