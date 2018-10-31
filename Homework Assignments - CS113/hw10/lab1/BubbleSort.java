package edu.miracosta.cs113.hw10.lab1;

public class BubbleSort
{

    public static void main(String[] args)
    {

        int[] array = {34, 21, 282, 85, 82, 3, 67, 4, 92, 104, 29};


        System.out.println("--- Unsorted Array ---");
        printArray(array);

        array = bubbleSort(array);

        System.out.println("\n\n--- Sorted Array ---");
        printArray(array);

    }

    private static int[] bubbleSort(int[] array)
    {
        boolean sortFlag;
        int temp;

        do
        {
            sortFlag = false;

            for (int i = 0; i < array.length - 1; i++)
            {
                if (array[i+1] < array[i])
                {
                    temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;
                    sortFlag = true;
                }
            }
        } while (sortFlag);

        return array;
    }

    private static void printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.println("Index " + (i+1) + " : " + array[i]);
        }
    }
}
