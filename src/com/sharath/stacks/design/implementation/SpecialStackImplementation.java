package com.sharath.stacks.design.implementation;

import java.util.Stack;

/**
 * This is a special stack. It supports push, pop, isEmpty, isFull and also an additional getMin() which returns
 * the minimum element in the stack at any given point of time. All are of O(1) time complexity. It uses two stacks internally
 * to achieve this. One is used for storing the elements themselves and the other stack for storing the minimum elements.  
 * @author sharath
 *
 */
public class SpecialStackImplementation 
{
	public static void main(String[] args) 
	{
		final SpecialStack ss = new SpecialStack();
		ss.push(18);
		ss.push(19);
		ss.push(29);
		ss.push(15); //<--- min 
		ss.push(16);
		
		System.out.println("Minimum now: "+ss.getMin());
		
		//Two pop operations and the min will change and should be 18. Since 16 and 15 will be gone.
		ss.pop();
		ss.pop();
		
		System.out.println("Minimum now: "+ss.getMin());
	}
	
	private static final class SpecialStack
	{
		final Stack<Integer> s1 = new Stack<>(); //to store elements
		final Stack<Integer> s2 = new Stack<>(); //to store minimum elements.
		
		private void push(int item)
		{
			//When s1 is empty the element inserted into it will be the only minimum element available.
			if(s1.isEmpty())
			{
				s1.push(item);
				s2.push(item); // item is the only min element at this point.
			}
			else
			{
				s1.push(item);
				//If the item being pushed is less than the minimum element available so far, push it into s2.
				if(item < s2.peek())
				{
					s2.push(item);
				}
			}
		}
		
		private int pop()
		{
			int elem=0;
			//If the element being popped is the minimum element avaiable so far, then it should 
			//also be popped from the s2 since it is no longer a minimum element.
			if(s1.peek() == s2.peek())
			{
				elem = s1.pop();
				s2.pop();
			}
			else
			{
				elem = s1.pop();
			}
			return elem;
		}
		
		private boolean isEmpty()
		{
			return s1.isEmpty();
		}
		
		//Returns the minimum element available so far in the s1 stack. This is same as the top element of s2.
		private int getMin()
		{
			if(!s2.isEmpty())
			{
				return s2.peek();
			}
			return -9999; //Indicates invalid.
		}
		//Since this Stack is a java stack whose length grows dynamically, I am not implementing the isFull
		//That should be straight forward if you use a regular stack.
	}
}
