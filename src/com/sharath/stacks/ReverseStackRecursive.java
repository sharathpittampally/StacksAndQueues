package com.sharath.stacks;
import java.util.Stack;
public class ReverseStackRecursive 
{
	public static void main(String[] args)
	{
		final Stack<Integer> s = new Stack<>();
		
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println(s);
		System.out.println(reverse(s, new Stack<Integer>()));
	}
	
	private static Stack<Integer> reverse(Stack<Integer> ip, Stack<Integer> result)
	{
		if(!ip.isEmpty())
		{
			int elem = ip.pop();
			result.push(elem);
			return reverse(ip, result);
		}
		return result;
	}
} 
