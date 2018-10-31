package edu.miracosta.cs113.hw10.part1;

/* Programmed By : Robert Esposito
   Date          : 04/24/17
   Class         : CS 113, Monday @ 5:30PM
   Assignment    : Homework #10

   Description: This program fully implements the Map interface
   for the class HashtableChain found in the book. It also implements
   the SetIterator inner class described in the book.

 */
public class HashtableTester
{
    public static void main(String[] args)
    {
        HashtableChain<Integer, String> table = new HashtableChain<>();

        table.put(1, "Banana");
        table.put(1, "Apple");
        table.put(2, "Peach");
        table.put(3, "Plum");
        table.put(4, "Date");
        table.put(5, "Apricot");
        table.put(6, "Banana");
        table.put(6, "Orange");

        if (table.containsKey(5))
        {
            System.out.println("Table contains key 5!");
        }
        else
        {
            System.out.println("Key 5 not found.");
        }

        if (table.containsKey(9))
        {
            System.out.println("Table contains key 9!");
        }
        else
        {
            System.out.println("Key 9 not found.");
        }

        if (table.containsValue("Banana"))
        {
            System.out.println("Table contains \"Banana\"");
        }

        System.out.println(table.get(1));
        System.out.println(table.get(9));

    }
}
