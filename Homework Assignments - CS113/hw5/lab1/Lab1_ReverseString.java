package edu.miracosta.cs113.hw5.lab1;

/* Programmed By : Robert Esposito
   Date          : 02/27/17
   Class         : CS 113, Monday @ 5:30PM
   Assignment    : Homework #5 - Lab 1

   Description: This program will reverse a String entered by
   the user using a Stack object.
 */

import java.util.Scanner;
import java.util.Stack;

public class Lab1_ReverseString
{
    public static void main(String[] args)
    {
        Stack<Character> stack = new Stack<>();
        StringBuilder outputString = new StringBuilder();
        String inputString;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("-- Reverse String Program --");
        System.out.print("Please enter a String: ");
        inputString = keyboard.nextLine();

        for (int i = 0; i < inputString.length(); i++)
        {
            stack.push(inputString.charAt(i));
        }

        for (int i = 0; i < inputString.length(); i++)
        {
            outputString.insert(i,stack.pop());
        }

        System.out.println("\nYour string is reversed: " + outputString.toString());
    }
}
