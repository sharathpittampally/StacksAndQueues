# Infix: Operator is in between the operands.
## Evaluating infix expressions:
   * You need to have two stacks one for operands and the other for operators.
   * When ever the next element in the expression is an operator and its of higher precedence
     than the element on the top of stack, push that element into the stack.
   * If the next element in the expression is of lower precedence than the top of stack, then pop the 
     top of stack, pop two elements from the operands and perform the operation and push the result into
     the top of operands stack.
   * If you encounter opening bracket, push it into the operators stack.
   * If you encounter a closing bracket, pop operators from the operators stack and perform operations    
     and pushing the result into the operands stack until you get the opening bracket.
   * After the expression parsing is done, check if there are any more elements in operators stack. 
   * If so, while the operators stack is empty keep popping and performing operations and storing the
     result in the operands stack.
   * Your final answer will be the single number present on the operands stack.

## Conversions:
### Infix to Postfix:
    This is direct, using stack and based on priorities. Now parse the given infix if you encounter  operand put it in result, if you encounter operator push into stack. But while pushing into stack if operator at top of stack is higher priority or equal to what you are pushing then simply pop and put in result until you reach lower priority operator in stack. If there are parenthesis, then push opening parenthesis into stack but when you encounter closing parenthesis in infix then pop stack and put in result until you reach opening parenthesis.

### Infix to Prefix: 
    Reverse the infix then convert to post fix. Reverse the obtained postfix result.
      