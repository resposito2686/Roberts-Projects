package edu.miracosta.cs113.hw5.lab4;

/* Programmed By : Robert Esposito
   Date          : 02/27/17
   Class         : CS 113, Monday @ 5:30PM
   Assignment    : Homework #5 - Lab 4

   Description: This program will test the class LLQueue and it's methods.
 */
public class LLQueueTester
{
    public static void main(String[] args)
    {
        LLQueue<String> queue = new LLQueue<>();

        queue.add("Bryan");
        queue.offer("Dave");
        queue.offer("Tony");
        queue.offer("Kennith");

        System.out.println("First person in queue: " + queue.peek());

        int count = 1;
        while (!queue.empty())
        {
            System.out.println("#" + count + " : " + queue.poll());
            count++;
        }
    }
}
