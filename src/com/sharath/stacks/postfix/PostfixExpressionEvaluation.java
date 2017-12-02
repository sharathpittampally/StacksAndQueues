package com.sharath.stacks.postfix;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class PostfixExpressionEvaluation 
{

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
		final Stack<Integer> operands = new Stack<>();
		final Set<Character> operators = new HashSet<>();
		operators.add('+');
		operators.add('-');
		operators.add('*');
		operators.add('/');
		char[] expArray = exp.toCharArray();
		for(char c : expArray)
		{
			if(operators.contains(c))
			{
				int op1 = operands.pop();
				int op2 = operands.pop();
				operands.push(performOperation(c, op1, op2));
			}
			else
			{
				operands.push(Character.getNumericValue(c));
			}
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
