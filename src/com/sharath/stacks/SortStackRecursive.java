package com.sharath.stacks;
import java.util.Stack;
public class SortStackRecursive 
{
	
	public static void main(String[] args) 
	{
		final Stack<Integer> s = new Stack<>();
		s.push(30);
        s.push(-5);
        s.push(18);
        s.push(14);
        s.push(-3);
        
        System.out.println("Before sorting: ");
        System.out.println(s);
        
        sort(s);
        System.out.println("After sorting: ");
        System.out.println(s);
	}
	
	/**
	 * The idea of the solution is to hold all values in Function Call Stack until the stack becomes empty
	 * . When the stack becomes empty, insert all held items one by one in sorted order. 
	 *  Here sorted order is important.
	 * @param s
	 */
	private static void sort(Stack<Integer> s)
	{
		if(!s.isEmpty())
		{
			int elem = s.pop();
			sort(s);
			sortedInsert(s, elem);
		}
	}
	
	private static void sortedInsert(final Stack<Integer> s, int elem)
	{
		if(s.isEmpty())
		{
			s.push(elem);
		}
		else if(s.peek() >= elem)
		{
			s.push(elem);
		}
		else
		{
			int top = s.pop();
			sortedInsert(s, elem);
			s.push(top);
		}
	}
}
