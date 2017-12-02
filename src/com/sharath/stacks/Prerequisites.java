package com.sharath.stacks;

import java.util.Stack;

/**
 * The question is there are prerequisite courses for each course. And they are
 * represented in form of a 2X2 matrix. First column represents the course and
 * the second column corresponding to it represents its prereq. For example if 1
 * is the prereq of 2 then courseInfo[2][1] = 1. We want you to return the array
 * of prereqs given the course info and the course to take.
 * 
 * @author sharath
 */
public class Prerequisites
{

    public static void main(String[] args)
    {
        /**
         * This course info has three courses. course 0 has prereq as null(in
         * which case there are no prereqs and just return the course itself).
         * course 1 has 0 as prereq and so on.
         */
        Integer[][] courseInfo = { { 0, null }, { 1, 0 }, { 2, 1 }, { 3, 2 } };

        int[] prereqstotake = prereqs(courseInfo, 3);
        System.out.println("Iterative....");
        for (int i = 0; i < prereqstotake.length; i++)
        {
            System.out.print(prereqstotake[i] + ",");
        }
        int[] prereqstotakerecursive = prereqsRecursive(courseInfo, 3);
        System.out.println();
        System.out.println("recursive");
        for (int i = 0; i < prereqstotakerecursive.length; i++)
        {
            System.out.print(prereqstotakerecursive[i] + ",");
        }
    }

    // Iterative solution
    private static int[] prereqs(Integer[][] courseInfo, int courseToTake)
    {
        Stack<Integer> s = new Stack<>();
        s.push(courseToTake);
        while (courseInfo[s.peek()][1] != null)
        {
            s.push(courseInfo[s.peek()][1]);
        }
        final int[] res = new int[s.size()];
        int i = 0;
        while (!s.isEmpty())
        {
            res[i] = s.pop();
            i++;
        }
        return res;
    }

    // recursive solution
    static int stackSize = 1;
    static int arrayIndex = 0;

    private static int[] prereqsRecursive(Integer[][] courseInfo, int courseToTake)
    {
        if (courseInfo[courseToTake][1] == null)
        {
            int[] res = new int[stackSize];
            res[arrayIndex] = courseToTake;
            arrayIndex++;
            return res;
        }
        stackSize++;
        int[] tempResHolder = prereqsRecursive(courseInfo, courseInfo[courseToTake][1]);
        tempResHolder[arrayIndex] = courseToTake;
        arrayIndex++;
        return tempResHolder;
    }
}
