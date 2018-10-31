package edu.miracosta.cs113.hw3.part2;

/* Programmed By : Robert Esposito
   Date          : 02/24/17
   Class         : CS 113, Monday @ 5:30PM
   Assignment    : Homework #3

   Description: This program will create a LinkedList of Student objects.
   Each object stores the name of the student along with their ID number.
   The user can add a student to the front or back of the list. They can also
   remove a student from the front of the list or remove a student by their
   name.

 */
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentList
{
    static LinkedList<Student> list = new LinkedList<>();

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
                    list.removeFirst();
                    break;
                case 4:
                    removeByName();
                    break;
                case 5:
                    printList();
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

    //Prints the menu for the user.
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

    //return: menu option the user entered.
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

    //adds a student to the front or back of the list, depending on the user's menu selection.
    public static void addToList(int x)
    {

        String name;
        String idNumber;

        Scanner keyboard = new Scanner(System.in);

        System.out.print("\nPlease enter the student's name: ");
        name = keyboard.nextLine();

        System.out.print("\nPlease enter the student's ID number: ");
        idNumber = keyboard.nextLine();

        if (x == 1)
        {
            list.addFirst(new Student(name, idNumber));
            System.out.println();
            System.out.println("Added " + name + " to front of the wait-list.");
        }
        else
        {
            list.addLast(new Student(name, idNumber));
            System.out.println();
            System.out.println("Added " + name + " to end of the wait-list.");
        }
    }

    //removes a student by name
    public static void removeByName()
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("What is the name of the student being deleted?: ");
        String name = keyboard.nextLine();

        int index = list.indexOf(new Student(name,""));

        if (index != -1)
        {
            list.remove(index);
            System.out.println("Removed " + name + " from the list.");
        }
        else
        {
            System.out.println("Cannot find a student with that name...");
        }
    }

    //prints the wait-list and the student's position in line.
    public static void printList()
    {
        int count = 1;
        for (Student a : list)
        {
            System.out.println(a);
            System.out.println("Position: " + count);
            count++;
        }
    }
}
