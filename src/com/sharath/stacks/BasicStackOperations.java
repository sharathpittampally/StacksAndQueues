package com.sharath.stacks;

public class BasicStackOperations 
{
    public static void main(String[] args)
    {
    	Stack s = Stack.initialize(10);
    	
    	//push
    	System.out.println("Push operations: ");
    	s.push(3);
    	s.push(5);
    	s.push(1);
    	s.push(19);
    	s.push(23);
    	s.push(87);
    	s.push(11);
    	s.push(0);
    	s.push(879);
    	s.push(2121);
    	
    	//print
    	s.printStack();
    	
    	
    	System.out.println("Push operations exceeding limit: ");
    	//push exceeding limit
    	s.push(550);
    	
    	System.out.println("Pop operations: ");
    	//pop
    	s.pop();
    	s.pop();
    	s.printStack();
    	s.pop();
    	s.printStack();
    	s.pop();
    	s.printStack();
    	s.pop();
    	s.pop();
    	s.pop();
    	s.pop();
    	s.pop();
    	s.pop();
    	s.printStack();
    	
    	System.out.println("Pop operations exceeding limits: ");
    	//pop exceeding limits
    	s.pop();
    }
}
