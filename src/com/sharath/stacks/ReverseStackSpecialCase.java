package com.sharath.stacks;

/**
 * Here reverse a stack in O(n) with not extra space.
 * @author sharath
 * This can be achieved if we design stack as a linked list. 
 */
public class ReverseStackSpecialCase 
{
	public static void main(String[] args) 
	{
		final Stack s = new Stack();
		Node n1 = new Node(1,null);
		Node n2 = new Node(2,null);
		Node n3 = new Node(3,null);
		Node n4 = new Node(4,null);
		Node n5 = new Node(5,null);
		
		s.push(n1);
		s.push(n2);
		s.push(n3);
		s.push(n4);
		s.push(n5);
		
		System.out.println("Before reverse:");
		s.display();
		
		s.reverse();
		
		System.out.println("After reverse: ");
		s.display();
	}
	
	
	/**
	 * Node in linked list.
	 * @author sharath
	 */
	private static final class Node
	{
		int data;
		Node link;
		
		private Node(int data, Node link)
		{
			this.data = data;
			this.link = link;
		}
		
		private int getData()
		{
			return data;
		}
		
		private void setLink(Node link)
		{
			this.link = link;
		}
		
		private Node getLink()
		{
			return link;
		}
	}
	
	private static final class Stack
	{
		Node top=null;
		void push(final Node n)
		{
			if(top==null)
			{
				top = n;
				n.setLink(null);
			}
			else
			{
				n.setLink(top);
				top = n;
			}
		}
		
		Node pop()
		{
			Node topNode = top;
			top = top.getLink();
			topNode.setLink(null);
			return topNode;
		}
		
		void display()
		{
			Node iterator = top;
			while(iterator != null)
			{
				System.out.println(iterator.getData());
				iterator = iterator.getLink();
			}
		}
		
		private void reverse()
		{
			Node prev = null;
			Node curr = top;
			
			while(curr != null)
			{
				Node next = curr.getLink();
				curr.setLink(prev);
				prev = curr;
				curr = next;
			}
			top = prev;
		}
	}
}
