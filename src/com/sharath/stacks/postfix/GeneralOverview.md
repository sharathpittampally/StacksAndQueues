# Postfix: Operator is after the two operands.
## This is straight forward. Follow the steps below:
   * One stack is enough for operands, we dont need to put operators in the stack.
   * Scan the expression from left to right. When you see a operand, push it to stack.
   * When you encounter a operator, pop the top two elements in the stack perform operation and 
     Push the result onto the stack.
   * Continue this process until all the expression is scanned.
   * NO NEED TO CARE ABOUT ANY RULES HERE.

## Conversions:
### Postfix to Infix:
    Parse the postfix string, if you encounter an operand push into stack, if you encounter operator pop the top two elements(operands) in the stack and make a new string such that operator is between the two popped operands and push this new string into the stack again. Repeat this until the entire expression is parsed.
    
### Postfix to Prefix:
    Parse the postfix, if it is an operand push onto stack, if it is an operator pop the top two elements in stack create a new string such that the operator is in front of two operands then push this new string onto stack. Repeat this until whole expression is parsed.