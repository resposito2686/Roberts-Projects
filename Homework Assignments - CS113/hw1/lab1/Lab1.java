package edu.miracosta.cs113.hw1.lab1;

public class Lab1
{
    public static void main(String[] args)
    {
        String fizz = "Fizz";
        String buzz = "Buzz";
        int[] nums = new int[100];

        for (int i = 0; i < nums.length; i++)
        {
            if (((i+1)%3 == 0) && ((i+1)%5 == 0))
            {
                System.out.print(fizz + buzz);
            }
            else if ((i+1)%3 == 0)
            {
                System.out.print(fizz);
            }

            else if ((i+1)%5 == 0)
            {
                System.out.print(buzz);
            }

            else
            {
                System.out.print((i+1));
            }

            System.out.println("\n");
        }
    }
}
