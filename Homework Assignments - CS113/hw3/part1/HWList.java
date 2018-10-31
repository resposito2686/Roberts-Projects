package edu.miracosta.cs113.hw3.part1;

/* Programmed By : Robert Esposito
   Date          : 02/13/17
   Class         : CS 113, Monday @ 5:30PM
   Assignment    : Homework #3

   Description: This program will create a list of Assignment objects.
   Each object stores the name of a Homework assignment along with its
   due date. The user can choose to add an assignment, remove an assignment,
   display all the assignments, or display the first assignment due.

 */

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HWList
{
    static ArrayList<Assignment> list = new ArrayList<>();

    public static void main(String[] args)
    {
        boolean menuFlag = true;
        int menu;

        while (menuFlag)
        {
            printMenu();
            menu = menuEntry();

            switch (menu)
            {
                case 1:
                    addHomework();
                    break;
                case 2:
                    removeHomework();
                    break;
                case 3:
                    printList();
                    break;
                case 4:
                    earliestAssignment();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please make a valid entry.");
            }
        }
    }

    //Prints the menu for the user.
    public static void printMenu()
    {
        System.out.println("*---- Homework Planner ----*");
        System.out.println("* <1> Add Assignment       *");
        System.out.println("* <2> Remove Assignment    *");
        System.out.println("* <3> List Assignments     *");
        System.out.println("* <4> Next Assignment Due  *");
        System.out.println("* <5> Exit Program         *");
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

    /* Adds an Assignment object to the ArrayList.
     * Checks the format of the date so the earliestAssignment method can function correctly.
     */
    public static void addHomework()
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("\nPlease enter the name of the assignment: ");
        String name = keyboard.nextLine();

        System.out.print("\nPlease enter the due date of the assignment (MM/DD/YY): ");
        String date = null;

        boolean dateFlag = true;

        while (dateFlag)
        {
            date = keyboard.nextLine();

            if (date.charAt(2) == '/' && date.charAt(5) == '/' && date.length() == 8)
            {
                dateFlag = false;
            }

            else
            {
                System.out.println("Please enter the date in a valid format (MM/DD/YY, include the '/'");
            }
        }
        System.out.println();

        list.add(new Assignment(name, date));
    }

    //Removes an object from the ArrayList with that matches the assignment name entered by the user.
    public static void removeHomework()
    {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("What is the name of the homework assignment being deleted?: ");
        String name = keyboard.nextLine();

        int index = list.indexOf(new Assignment(name,""));

        if (index != -1)
        {
            list.remove(index);
        }
        else
        {
            System.out.println("Cannot find an assignment with that name...");
        }
    }

    //Displays the ArrayList
    public static void printList()
    {
        for (Assignment a : list)
        {
            System.out.println(a);
        }
    }

    /* Compares the Year, Month and Day (in that order) of the assignments and displays the one with
     * the earliest due date.
     */
    public static void earliestAssignment()
    {
        Assignment temp = list.get(0);

        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getDueDateYear() < temp.getDueDateYear())
            {
                temp = list.get(i);
            }

            else if (list.get(i).getDueDateYear() == temp.getDueDateYear())
            {
                if (list.get(i).getDueDateMonth() < temp.getDueDateMonth())
                {
                    temp = list.get(i);
                }

                else if (list.get(i).getDueDateMonth() == temp.getDueDateMonth())
                {
                    if (list.get(i).getDueDateDay() < temp.getDueDateDay())
                    {
                        temp = list.get(i);
                    }
                    else;
                }
                else;
            }
            else;
        }
        System.out.println(temp.toString());
    }
}
