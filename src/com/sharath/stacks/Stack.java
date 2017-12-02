package com.sharath.stacks;

class Stack 
{
	private final int size;
	private final int[] array;
	private int top=-1;
	
	private Stack(int size)
	{
		this.size = size;
		array = new int[size];
	}
	
	static Stack initialize(int size)
	{
		return new Stack(size);
	}
	
	void push(int elem)
	{
		if(isFull())
		{
			System.out.println("Stack is full");
		}
		else
		{
			array[++top] = elem;
			top++;
		}
	}
	
	void pop()
	{
		if(isEmpty())
		{
			System.out.println("Stack is empty");
		}
		else
		{
			System.out.println("Popped out: "+array[top]);
			top--;
		}
	}
	
	void printStack()
	{
		for(int i=0;i<=top;i++)
		{
			System.out.println(array[i]);
		}
	}
	boolean isEmpty()
	{
		return top == -1 ? true : false;
	}
	
	boolean isFull()
	{
		return size == top+1 ? true : false;
	}
}
