# Prefix: Operator comes before the operands.
## This is similar to post fix, its just a reverse of it.
   * Since this is exactly reverse of the postfix evaluation, we reverse the expression first.
   * Just reverse the given expression and follow the same steps as the post fix.
   
## Conversions:
### Prefix to Infix:
    Reverse prefix, then convert this reversed string to infix like you convert post fix to infix then again reverse this converted string.
    
### Prefix to Postfix:
    Prefix to infix, then infix to postfix.