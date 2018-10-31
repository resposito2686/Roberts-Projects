package edu.miracosta.cs113.hw5.part2;

import java.util.LinkedList;

/** queue used for widgets */
public class WidgetQueue_P2<E>
{
    private LinkedList<E> queue;

    public WidgetQueue_P2()
    {
        queue = new LinkedList<E>();
    }

    /** Adds an item to the end of the queue and returns true when successful */
    boolean add(E data)
    {
        queue.addFirst(data);
        return true;
    }

    /** Returns the first item in the queue */
    E element()
    {
        return queue.getLast();
    }

    /** Adds an item to the end of the queue */
    void offer(E data)
    {
        queue.addFirst(data);
    }

    /** Returns the first item in the queue unless the queue is empty */
    E peek()
    {
        if (empty())
        {
            return null;
        }
        else
        {
            return queue.getLast();
        }
    }

    /** Removes and returns the first item in the queue unless the queue is empty */
    E poll()
    {
        if (empty())
        {
            return null;
        }
        else
        {
            E temp = queue.getLast();
            queue.removeLast();
            return temp;
        }
    }

    /** Removes and returns the first item in the queue */
    E remove()
    {
        E temp = queue.getLast();
        queue.removeLast();
        return temp;
    }

    /** Returns true if the queue is empty, false if it is not. */
    boolean empty()
    {
        return queue.isEmpty();
    }
}
