package edu.miracosta.cs113.hw1.lab2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab2
{
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in);

        boolean foundFlag = false;
        int num = 0;

        System.out.print("Please enter a number: ");

        try
        {
            num = keyboard.nextInt();
        }

        catch (InputMismatchException e)
        {
            System.out.println("A number was not entered.");
            System.exit(0);
        }

        double numD = (double)num;

        for (int i = 1; i < 50; i++)
        {
            double tempNum = Math.pow(2, i);

            if (tempNum == numD)
            {
                foundFlag = true;
            }
        }

        System.out.println();
        if (foundFlag)
        {
            System.out.println(num + " is a power of 2");
        }
        else
        {
            System.out.println(num + " is NOT a power of 2");
        }
    }
}
