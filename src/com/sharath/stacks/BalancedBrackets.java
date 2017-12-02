package com.sharath.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.Scanner;

public class BalancedBrackets 
{
	static final Map<Character, Character> brackets = new HashMap<>();
	
	public static void main(String[] args)
	{
		brackets.put('[',']');
		brackets.put('{', '}');
		brackets.put('(', ')');
		brackets.put('<', '>');
		
		System.out.println("Enter the expression: ");
		Scanner s = new Scanner(System.in);
		System.out.println("The expression is balanced? :"+isBalanced(s.nextLine()));
		s.close();
	}
	
	private static boolean isBalanced(final String exp)
	{
		final Stack<Character> s = new Stack<Character>();
		char[] expArray = exp.toCharArray();
		for(char c : expArray)
		{
			if(brackets.containsKey(c))
			{
				s.push(c);
			}
			else if(brackets.containsValue(c))
			{
				char top = s.peek();
				if(brackets.get(top) == c)
				{
					s.pop();
				}
			}
		}
		if(s.isEmpty())
			return true;
		return false;
	}
}
