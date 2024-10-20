package Easytasks;

import java.util.Stack;
public class Intersection {
    class Solution {
        public boolean parseBoolExpr(String expression) {
            Stack<Character> stack = new Stack<>();

            for (char c : expression.toCharArray()) {
                if (c == ',' || c == '(') {
                    // Skip commas and open parentheses
                    continue;
                }

                if (c == 't' || c == 'f' || c == '!' || c == '&' || c == '|') {
                    // Push true, false, or operators onto the stack
                    stack.push(c);
                } else if (c == ')') {
                    // Process the sub-expression inside the parentheses
                    Stack<Character> tempStack = new Stack<>();
                    while (stack.peek() != '!' && stack.peek() != '&' && stack.peek() != '|') {
                        tempStack.push(stack.pop());
                    }

                    char operator = stack.pop();
                    boolean result = evaluate(tempStack, operator);

                    // Push the result back to the stack as 't' (true) or 'f' (false)
                    stack.push(result ? 't' : 'f');
                }
            }

            // The final result should be the only element in the stack
            return stack.pop() == 't';
        }

        private boolean evaluate(Stack<Character> operands, char operator) {
            boolean result;
            if (operator == '!') {
                // NOT operator only has one operand
                result = operands.pop() == 'f';
            } else if (operator == '&') {
                // AND operator: all operands must be true
                result = true;
                while (!operands.isEmpty()) {
                    result &= (operands.pop() == 't');
                }
            } else { // operator == '|'
                // OR operator: at least one operand must be true
                result = false;
                while (!operands.isEmpty()) {
                    result |= (operands.pop() == 't');
                }
            }
            return result;
        }
    }
}