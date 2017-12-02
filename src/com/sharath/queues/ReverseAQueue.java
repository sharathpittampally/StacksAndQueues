package com.sharath.queues;
import java.util.Queue;
import java.util.LinkedList;
public class ReverseAQueue
{
    public static void main(String[] args)
    {
        final Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(reverse(queue));
    }

    private static Queue<Integer> reverse(final Queue<Integer> q)
    {
        if(q.isEmpty())
        {
            return q;
        }
        int elem = q.remove();
        Queue x = reverse(q);
        x.add(elem);
        return x;
    }
}
