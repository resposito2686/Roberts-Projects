package edu.miracosta.cs113.hw5.lab3;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Lab3_MyStack<E>
{
    private ArrayList<E> list = new ArrayList<>();

    /** Adds an object to the front of the stack and then returns the object.
     * @param: dataObj - Object being added to list
     * @return: dataObj - Object being added to list
     */
    protected E push(E dataObj)
    {
        list.add(dataObj);
        return dataObj;
    }

    /** Removes and returns the object at the top of the stack unless the stack is empty.
     * @return: The last object in list.
     * @throws: EmptyStackException if list is empty.
     */
    protected E pop()
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

    /** Returns the object at the top of the stack unless the stack is empty.
     * @return: The last object in list.
     * @throws: EmptyStackException if list is empty.
     */
    protected E peek()
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

    /** Returns true if there are no objects in the stack, false if it is not.
     * @return true if list is empty, false if not.
     */
    protected boolean empty()
    {
        return list.isEmpty();
    }
}
