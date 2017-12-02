package com.sharath.queues;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues 
{
	public static void main(String[] args)
	{
		final Stack s = new Stack();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		
		s.print();
		
		s.pop();
		s.pop();
		
		s.print();
	}
	
	private static final class Stack
	{
		final Queue<Integer> q1 = new LinkedList<>();
		final Queue<Integer> q2 = new LinkedList<>();
		
		private void push(final int i)
		{
			if(q1.isEmpty() && q2.isEmpty())
			{
				q1.add(i);
			}
			else if(!q1.isEmpty())
			{
				q1.add(i);
			}
			else if(!q2.isEmpty())
			{
				q2.add(i);
			}
		}
		
		private int pop()
		{
			int elemToPop = 0;
			if(!q1.isEmpty())
			{
				elemToPop = q1.remove();
				
				do
				{
					q2.add(elemToPop);
					elemToPop = q1.remove();
					
				}while(!q1.isEmpty());
			}
			else if(!q2.isEmpty())
			{
                elemToPop = q2.remove();
				
				do
				{
					q1.add(elemToPop);
					elemToPop = q2.remove();
					
				}while(!q2.isEmpty());
			}
			return elemToPop;
		}
		
		private void print()
		{
			if(!q1.isEmpty())
			{
				System.out.println(q1);
			}
			
			else
			{
				System.out.println(q2);
			}
		}
	}
}
