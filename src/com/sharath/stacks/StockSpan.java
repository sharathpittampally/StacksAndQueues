package com.sharath.stacks;
import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/the-stock-span-problem/
 * @author sharath
 *
 */
public class StockSpan 
{
	public static void main(String[] args) 
	{
		int[] prices = {100, 80, 60, 70, 60, 75, 85};
		for(int i : span(prices, prices.length))
		{
			System.out.println(i);
		}
	}
	
	private static int[] span(int[] prices, int days)
	{
		final Stack<Integer> s = new Stack<>();
		int[] stackSpanResults = new int[days];
		stackSpanResults[0] = 1;
		s.push(0);
		for(int i=1;i<days;i++)
		{
			while(!s.isEmpty() && prices[s.peek()] <= prices[i])
				s.pop();
			stackSpanResults[i] = s.isEmpty() ? i+1 : i-s.peek();
			s.push(i);
		}
		return stackSpanResults;
	}
}
