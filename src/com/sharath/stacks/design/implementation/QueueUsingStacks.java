package com.sharath.stacks.design.implementation;
import java.util.Stack;

/**
 * Use two stacks to achieve this. Keep pushing into s1. When a pop is called, check if s2 is empty,
 * If not pop from s2 if its empty then load s2 by poping from s1 and pushing to s2. until s1 is empty.
 * @author sharath
 *
 */
public class QueueUsingStacks
{
	public static void main(String[] args) 
	{
		final Queue queue = new Queue();
		for(int i=0;i < 6; i++)
		{
			queue.push(i);
		}
		
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		System.out.println(queue.pop());
		
		for(int i=6;i<11;i++)
		{
			queue.push(i);
		}
	}
	
	private static class Queue
	{
		final Stack<Integer> s1 = new Stack<>();
		final Stack<Integer> s2 = new Stack<>();
		
		private void push(int elem)
		{
			s1.push(elem);
		}
		
		private int pop()
		{
			if(s2.isEmpty())
			{
				loadStack2();
			}
			return s2.pop();
		}
		
		private void loadStack2()
		{
			while(!s1.isEmpty())
			{
				s2.push(s1.pop());
			}
		}
	}
}
