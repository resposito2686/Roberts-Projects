package edu.miracosta.cs113.hw3.lab1;


import java.util.ArrayList;

public class Lab1_Part1
{
    public static void main(String[] args)
    {
        ArrayList<String> list = new ArrayList<>();

        System.out.println("Adding 20 elements to the ArrayList...");

        for (int i = 0; i < 20; i++)
        {
            list.add("Fizz");
        }

        System.out.println("\nArray List: ");
        printList(list);

        System.out.println("\nReplacing elements in the ArrayList...");
        System.out.println("\nArray List: ");

        list = replace(list, "Fizz", "Buzz");

        printList(list);

        System.out.println("\nDeleting the first instance of \"Delete Test\"...");
        list = delete(list, "Delete Test");

        printList(list);
    }

    /* @param: The ArrayList being modified.
     * @param: The object that is going to be replaced.
     * @param: The new object that will replace the previous object.
     * return: The ArrayList with the new objects replacing the previous objects.
     */
    static ArrayList<String> replace(ArrayList<String> aList, String oldItem, String newItem)
    {
        boolean replaceFlag = true;

        while (replaceFlag)
        {
            if (aList.indexOf(oldItem) == 8)
            {
                aList.set(8, "Delete Test");
            }
            if (aList.indexOf(oldItem) != (-1))
            {
                int index = aList.indexOf(oldItem);
                aList.set(index, newItem);
            }
            else
            {
                replaceFlag = false;
            }
        }
        return aList;
    }
    /* @param: The ArrayList that holds the object being deleted.
     * @param: The object that will be deleted.
     * return: The ArrayList after the object has been deleted.
     */
    static ArrayList<String> delete(ArrayList<String> aList, String target)
    {
        int index = aList.indexOf(target);
        aList.remove(index);
        return aList;
    }

    // @param: The ArrayList that will be output to the user.
    static void printList(ArrayList<String> list)
    {
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println((i+1) + ". " + list.get(i));
        }
    }
}
