package edu.miracosta.cs113.hw6.part2;

/* Programmed By : Robert Esposito
   Date          : 03/12/17
   Class         : CS 113, Monday @ 5:30PM
   Assignment    : Homework #6

   Description: This program will use a recursive method to display
   the different possible change combinations for the amount entered
   by the user.

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RecursiveChangeMachine
{
    private static ArrayList<int[]> list = new ArrayList<>();

    public static void main(String[] args)
    {
        int amount;
        System.out.print("Enter amount in cents: ");
        amount = intInput();
        generateChange(amount, 0, 0, 0, amount);

        // Output combinations
        System.out.println("\nChange combinations for " + amount + " cents:");
        for (int[] a : list)
        {
            System.out.println("Quarters: " + a[0] + "  Dimes: " + a[1] + "  Nickels: "
                    + a[2] + "  Pennies: " + a[3]);
        }
    }

    public static int intInput()
    {
        Scanner keyboard = new Scanner(System.in);
        int amount = 0;
        boolean loopFlag = true;
        while (loopFlag)
        {
            try
            {
                amount = keyboard.nextInt();

                if (amount < 0)
                {
                    throw new InputMismatchException();
                }
                loopFlag = false;
            }
            catch (InputMismatchException e)
            {
                System.out.println("Please make a valid entry");
            }
        }

        return amount;
    }
     /** Displays all combinations of coins */
    public static void generateChange(int total, int q, int d, int n, int p)
    {

        // Base Case
        if (q * 25 + d * 10 + n * 5 + p > total)
        {
            return;
        }

        saveChange(q, d, n, p);

        if (p >= 5)
        {
            generateChange(total, q, d, n + 1, p - 5);
        }
        if (p >= 10)
        {
            generateChange(total, q, d + 1, n, p - 10);
        }
        if (p >= 25)
        {
            generateChange(total, q + 1, d, n, p - 25);
        }
    }


     /** Store the current combination of change. If the combination
       * is already stored, returns nothing */
    public static void saveChange(int q, int d, int n, int p)
    {
        int[] changeCombo = { q, d, n, p };

        for (int[] combo : list)
        {
            if (Arrays.equals(changeCombo, combo))
            {
                return;
            }
        }
        list.add(changeCombo);
    }
}

