package edu.miracosta.cs113.hw5.part2;

import java.util.ArrayList;
import java.util.EmptyStackException;

/** Stack used for orders */
public class WidgetStack_P2<E>
{
    private ArrayList<E> list = new ArrayList<>();

    E push(E data)
    {
        list.add(data);
        return data;
    }

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

    boolean empty()
    {
        return list.isEmpty();
    }
}
