package edu.miracosta.cs113.hw3.lab1;

import java.util.ArrayList;

public class DirectoryEntryTest
{
    static ArrayList<DirectoryEntry> theDirectory = new ArrayList<>();

    public static void main(String[] args)
    {

        theDirectory.add(new DirectoryEntry("Jane Smith", "555-823-9384"));
        theDirectory.add(new DirectoryEntry("John Doe", "555-938-8830"));
        theDirectory.add(new DirectoryEntry("Ben Johnson", "555-084-3700"));

        System.out.println("Array List: ");
        printList(theDirectory);

        System.out.println("\nFinding John Doe...");
        System.out.println(findEntry(theDirectory,"John Doe"));

        System.out.println("\nChanging Ben Johnson's number...");
        addOrChangeEntry("Ben Johnson", "555-333-2468");

        printList(theDirectory);

        System.out.println("\nAdding Kip Kyle...");
        addOrChangeEntry("Kip Kyle", "555-920-8229");

        printList(theDirectory);

    }

    /* @param: ArrayList containing the directory
     * @param: The name of the person being searched for
     * return: The object that matches the search parameter or null if object can't be found.
     */
    public static DirectoryEntry findEntry(ArrayList<DirectoryEntry> list, String name)
    {
        int index = list.indexOf(new DirectoryEntry(name,""));

        if (index != -1)
        {
            return list.get(index);
        }
        else
        {
            return null;
        }

    }

    // @param: name and number of the person being added or changed
    public static void addOrChangeEntry(String name, String number)
    {
        int index = (-1);

        for (int i = 0; i < theDirectory.size(); i++)
        {
            if (theDirectory.get(i) == findEntry(theDirectory, name))
            {
                index = i;
            }

        }
        if (index != -1)
        {
            theDirectory.set(index, new DirectoryEntry(name,number));
        }

        else
        {
            theDirectory.add(new DirectoryEntry(name,number));
        }
    }

    //@param: the ArrayList that will be output to the user.
    public static void printList(ArrayList<DirectoryEntry> list)
    {
        for (DirectoryEntry d: list)
        {
            System.out.println(d);
        }
    }

}
