package com.sharath.stacks.infix;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class InfixExpressionEvaluation 
{
    final static Map<Character, Integer> rules = new HashMap<>();
    final static Stack<Integer> operands = new Stack<>();
    final static Stack<Character> operators = new Stack<>();
    static
    {
    	rules.put('+', 1);
    	rules.put('-', 1);
    	rules.put('*', 2);
    	rules.put('/', 2);
    	rules.put('(', 0);
    }
    		
    public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the expression: ");
		String exp = s.nextLine();
		System.out.println("Expression value is: "+evaluate(exp));
		s.close();
	}
	
	private static int evaluate(final String exp)
	{	
		final char[] expArray = exp.toCharArray();
		for(char c : expArray)
		{
			if(!rules.containsKey(c) && ((c != ')') && (c != '(')))
			{
				operands.push(Character.getNumericValue(c));
			}
			else
			{
				if(operators.isEmpty())
				{
					operators.push(c);
				}
				else if(c == '(')
				{
					operators.push(c);
				}
				else if(c == ')')
				{
					while(operators.peek() != '(')
					{
						char operator = operators.pop();
						int operand1 = operands.pop();
						int operand2 = operands.pop();
						operands.push(performOperation(operator, operand1, operand2));
					}
					operators.pop();
				}
				else if(rules.get(c) > rules.get(operators.peek()))
				{
					operators.push(c);
				}
				else if(rules.get(c) <= rules.get(operators.peek()))
				{
					char operator = operators.pop();
					int operand1 = operands.pop();
					int operand2 = operands.pop();
					operands.push(performOperation(operator, operand1, operand2));
					operators.push(c);
				}
			}
		}
		
		while(!operators.isEmpty())
		{
			operands.push(performOperation(operators.pop(), operands.pop(), operands.pop()));
		}
		return operands.pop();
	}
	
	private static int performOperation(char operator, int operand1, int operand2)
	{
		int res=0;
		switch(operator)
		{
			case '+':
				res= operand1+operand2;
				break;
			case '-':
				res= operand2-operand1;
				break;
			case '*':
				res= operand1*operand2;
				break;
			default:
				res= operand2/operand1;
		}
		return res;
	}
}
