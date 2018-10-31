package edu.miracosta.cs113.hw5.lab3;

/* Programmed By : Robert Esposito
   Date          : 02/27/17
   Class         : CS 113, Monday @ 5:30PM
   Assignment    : Homework #5 - Lab 3

   Description: This program will create a stack of Integer objects using the
   Lab3_MyStack class. It will then get the values from the first stack and store
   them in a second stack object and a Queue object. It will then output the objects
   in the order they are stored.
 */


import java.util.LinkedList;
import java.util.Queue;

public class Lab3_Queues
{
    static Lab3_MyStack<Integer> stack1 = new Lab3_MyStack<>();
    static Lab3_MyStack<Integer> stack2 = new Lab3_MyStack<>();
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args)
    {
        addToFirst();
        copyFirstStack();
        print();
    }

    /** Adds Integers to the first stack */
    public static void addToFirst()
    {
        stack1.push(-1);
        stack1.push(15);
        stack1.push(23);
        stack1.push(44);
        stack1.push(4);
        stack1.push(99);
    }

    /** Copies the objects from the first stack into a second stack and into a queue */
    public static void copyFirstStack()
    {
        while (!stack1.empty())
        {
            Integer temp = stack1.pop();
            stack2.push(temp);
            queue.add(temp);
        }
    }

    /** Outputs the objects in the second stack and the queue */
    public static void print()
    {
        int count = 1;

        while (!stack2.empty())
        {
            System.out.println("Object #" + count + " in Stack: " + stack2.pop());
            System.out.println("Object #" + count + " in Queue: " + queue.poll());
            System.out.println();
            count++;
        }
    }
}
