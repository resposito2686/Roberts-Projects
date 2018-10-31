package edu.miracosta.cs113.hw1.part1;

/* Programmed By : Robert Esposito
   Date          : 01/29/17
   Class         : CS 113, Monday @ 5:30PM
   Assignment    : Homework #1

   Description: This program will try to solve the Clue game.
   It uses the AssistantJack class to determine if the guess
   is correct.

 */

public class Solution
{
    public static void main(String[] args)
    {
        AssistantJack jack = new AssistantJack(0);

        int weapon = 1;
        int location = 1;
        int murderer = 1;
        boolean foundFlag = true;
        int sCheck = 1;

        // Loops until a solution is found
        while (foundFlag)
        {
            int check = jack.checkAnswer(weapon, location, murderer);

            /* Increments each variable if checkAnswer says the previous
               one was incorrect. */
            if (check == 1)
            {
                weapon++;
            }

            if (check == 2)
            {
                location++;
            }

            if (check == 3)
            {
                murderer++;
            }

            if (check == 0)
            {
                foundFlag = false;
            }

            System.out.println("Checking solution #" + sCheck);
            sCheck++;
        }

        System.out.println("\n"
                + TheoryItem.getPersonName(murderer)
                + " did it in the "
                + TheoryItem.getLocationName(location)
                + " with the "
                + TheoryItem.getWeaponName(weapon)
                + "!");

        System.out.println("\nAnswer set: " + weapon + ", "
                + location + ", " + murderer);

    }
}
