package edu.miracosta.cs113.hw5.lab2;

/* Programmed By : Robert Esposito
   Date          : 02/27/17
   Class         : CS 113, Monday @ 5:30PM
   Assignment    : Homework #5 - Lab 2

   Description: This program will reverse a String entered by
   the user using the class Lab2_MyStack.
 */

import java.util.Scanner;

public class Lab2_ReverseString
{
    public static void main(String[] args)
    {
        Lab2_MyStack<Character> stack =  new Lab2_MyStack<>();
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

        System.out.println(stack.peek()); //Testing the peek method.

        for (int i = 0; i < inputString.length(); i++)
        {
            outputString.insert(i,stack.pop());
        }

        System.out.println("\nYour string is reversed: " + outputString.toString());
    }
}
