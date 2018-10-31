package edu.miracosta.cs113.hw8.part1;

import java.util.ArrayList;
import java.util.EmptyStackException;

/* Stack class that is used for the iterator */
public class IteratorStack<E>
{
    private ArrayList<E> list = new ArrayList<>();

    /** Adds an object to the end of the queue */
    E push(E data)
    {
        list.add(data);
        return data;
    }

    /** Returns and deletes the first object in the queue unless the queue is empty */
    E pop()
    {
        if (empty())
        {
            throw new EmptyStackException();
        }

        else
        {
            E temp = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return temp;
        }
    }

    /** Returns the first object in the queue unless the queue is empty */
    E peek()
    {
        if (empty())
        {
            throw new EmptyStackException();
        }

        else
        {
            return list.get(list.size() - 1);
        }
    }

    /** Returns true if the queue is empty, false if it is not */
    boolean empty()
    {
        return list.isEmpty();
    }
}
