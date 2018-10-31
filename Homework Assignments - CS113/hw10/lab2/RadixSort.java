package edu.miracosta.cs113.hw10.lab2;

import java.util.LinkedList;
import java.util.Queue;


public class RadixSort
{
    private static final int NUM_OF_BUCKETS = 10; //How many buckets there are (always 10).
    private static Queue<Integer>[] buckets = new Queue[NUM_OF_BUCKETS];
    public static void main(String[] args)
    {
        //Initializes each Queue in the array.
        for (int i = 0; i < NUM_OF_BUCKETS; i++)
        {
            buckets[i] = new LinkedList<>();
        }

        int[] numArray = {1023, 7373, 73, 818, 960, 83, 7, 9382, 1111, 959, 701, 1, 406};

        //Determines how many digits the sort will go through
        for (int divisor = 1; divisor <= 1000; divisor *= 10)
        {
            numArray = radixSort(numArray, divisor);
        }
        printArray(numArray);
    }

    /** Sorts the array using a Radix Sort.
     * @param numArray - the array that needs to be sorted.
     * @param divisor  - determines which bucket the number goes into.
     * @return the sorted array.
     */
    private static int[] radixSort(int[] numArray, int divisor)
    {
        int indexTrack = 0; //Tracks the index of the array when pull numbers off the queue buckets.

        //Adds each integer to its appropriate bucket.
        for (int i = 0; i < numArray.length; i++)
        {
            buckets[(numArray[i]/divisor) % 10].add(numArray[i]);
        }

        //Pulls each number off the queue and adds it back to the array.
        for (int j = 0; j < NUM_OF_BUCKETS; j++)
        {
            while (!(buckets[j].isEmpty()))
            {
                numArray[indexTrack] = buckets[j].poll();
                indexTrack++;
            }
        }
        return numArray;
    }

    /** Prints the array */
    private static void printArray(int[] numArray)
    {
        for (int i = 0; i < numArray.length; i++)
        {
            System.out.println("Index " + (i+1) + " : " + numArray[i]);
        }
    }
}
