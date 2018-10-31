package edu.miracosta.cs113.hw4;

/* Programmed By : Robert Esposito
   Date          : 02/26/17
   Class         : CS 113, Monday @ 5:30PM
   Assignment    : Homework #4

   Description: This program will create a KWLinkedList of String objects that
   represent a student on a wait-list for a class. The user can add a student
   to the front or back of the list. They can also remove a student from the
   front of the list or remove a student by their name.

 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentList2
{
    private static KWLinkedList<String> list = new KWLinkedList<String>();

    public static void main(String[] args)
    {
        boolean menuFlag = true;
        int menuNum;

        while (menuFlag)
        {
            printMenu();
            menuNum = menuEntry();
            switch (menuNum)
            {
                case 1:
                    addToList(menuNum);
                    break;
                case 2:
                    addToList(menuNum);
                    break;
                case 3:
                    list.removeFromFront();
                    break;
                case 4:
                    removeByName();
                    break;
                case 5:
                    list.printList();
                    break;
                case 6:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please make a valid menu selection...");
                    break;
            }
        }
    }

    //Prints the menu
    public static void printMenu()
    {
        System.out.println("\n*------ Student Wait-list ------*");
        System.out.println("* <1> Add Student to Front      *");
        System.out.println("* <2> Add Student to Back       *");
        System.out.println("* <3> Remove Student from Front *");
        System.out.println("* <4> Remove Student by Name    *");
        System.out.println("* <5> Display List              *");
        System.out.println("* <6> Exit Program              *");
    }

    /* Takes an integer value from the user. Throws exception if something else is entered.
     * @return: value user entered.
     */
    public static int menuEntry()
    {
        Scanner keyboard = new Scanner(System.in);
        int input = 0;
        boolean inputOK = true;

        while (inputOK)
        {
            try
            {
                input = keyboard.nextInt();
                inputOK = false;
            }

            catch (InputMismatchException e)
            {
                System.out.println("Please enter a number to make a selection.");
            }
        }

        return input;
    }

    /* Adds an item to the front or back of the list.
     * @param: menuNum
     */
    public static void addToList(int menuNum)
    {

        String name;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("\nPlease enter the student's name: ");
        name = keyboard.nextLine();

        if (menuNum == 1)
        {
            list.addToFront(name);
        }
        else
        {
            list.addToBack(name);
        }
    }

    //Removes the item that matches what the user enters.
    public static void removeByName()
    {
        String name;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("\nPlease enter the student's name: ");
        name = keyboard.nextLine();

        list.removeByName(name);
    }
}
