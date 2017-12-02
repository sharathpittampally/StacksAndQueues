package com.sharath.stacks;

/**
 * Given arrival and departure times of all trains that reach a railway station,
 * find the minimum number of platforms required for the railway station so that
 * no train waits.
 * 
 * @author sharath
 *
 */
public class Railwaystations
{
    public static void main(String[] args)
    {
        int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
        int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };

        String[] ad = new String[arr.length + dep.length];

        int[] sortedTimes = new int[arr.length + dep.length];
        // sorting the times.
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < arr.length && j < dep.length)
        {
            if (arr[i] <= dep[j])
            {
                sortedTimes[k] = arr[i];
                ad[k] = "A";
                i++;
                k++;
            }
            else
            {
                sortedTimes[k] = dep[j];
                ad[k] = "D";
                j++;
                k++;
            }
        }

        while (i < arr.length)
        {
            sortedTimes[k] = arr[i];
            ad[k] = "A";
            k++;
            i++;
        }
        while (j < dep.length)
        {
            sortedTimes[k] = dep[j];
            ad[k] = "D";
            k++;
            j++;
        }

        System.out.println("minimum required platforms: " + minNumberOfPlatforms(sortedTimes, ad));
    }

    private static int minNumberOfPlatforms(int[] sortedTimes, String[] ad)
    {
        int totalPlatforms = 0;
        int availPlatforms = 0;

        for (int i = 0; i < sortedTimes.length; i++)
        {
            if ("D".equals(ad[i]))
            {
                availPlatforms++;
            }
            else if (availPlatforms == 0 && "A".equals(ad[i]))
            {
                totalPlatforms++;
            }
            else if (availPlatforms > 0 && "A".equals(ad[i]))
            {
                availPlatforms--;
            }
        }
        return totalPlatforms;
    }
}
