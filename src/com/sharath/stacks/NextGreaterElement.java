package com.sharath.stacks;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/next-greater-element/
 * @author sharath
 *
 */
public class NextGreaterElement 
{
	public static void main(String[] args) 
	{
		int[] arr1 = {4,5,2,15};
		int[] arr2 = {13,7,6,12};
		
		for(int i : printNextGreaterElements(arr1))
		{
			System.out.print(i+",");
		}
		
		System.out.println();
		
		for(int i : printNextGreaterElements(arr2))
		{
			System.out.print(i+",");
		}
	}
	
	private static int[] printNextGreaterElements(final int[] arr)
	{
		final Stack<Integer> s =  new Stack<>();
		int[] nge = new int[arr.length];
		s.push(0);
		for(int i=1;i<arr.length;i++)
		{
			if(arr[i] <= arr[s.peek()])
			{
				s.push(i);
			}
			else
			{
				while(!s.isEmpty() && arr[s.peek()] < arr[i])
				{
					nge[s.pop()] = arr[i];
				}
				s.push(i);
			}
		}
		
		while(!s.isEmpty())
		{
			nge[s.pop()] = -1;
		}
		return nge;
	}
}
