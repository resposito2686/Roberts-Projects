package edu.miracosta.cs113.hw4;

import java.util.NoSuchElementException;

public class KWLinkedList<E>
{
    private Node head;
    private Node tail;
    private int size;

    //Constructor sets list size to 0.
    public KWLinkedList()
    {
        size = 0;
    }

    //Node class for the Linked List.
    private class Node
    {
        E dataItem;
        Node next;
        Node prev;

        public Node(E dataItem, Node next, Node prev)
        {
            this.dataItem = dataItem;
            this.next = next;
            this.prev = prev;
        }

        public String toString()
        {
            return dataItem + "\n";
        }
    }

    //@return: Size of the list.
    public int getSize()
    {
        return size;
    }

    /* Adds an item to the front of the list
     * @param: dataItem
     */
    public void addToFront(E dataItem) {
        Node temp = new Node(dataItem, head, null);

        if (head != null) {
            head.prev = temp;
        }

        head = temp;

        if (tail == null) {
            tail = temp;
        }

        size++;
        System.out.println("Adding " + dataItem + " to the front of the list.");
    }

    /* Adds an item to the back of the list
     * @param: dataItem
     */
    public void addToBack(E dataItem) {

        Node temp = new Node(dataItem, null, tail);

        if (tail != null) {
            tail.next = temp;
        }

        tail = temp;

        if (head == null) {
            head = temp;
        }

        size++;
        System.out.println("Adding " + dataItem + " to the back of the list.");
    }

    /* Removes an item from the list that matches the one passed in
     * @param: dataItem
     */
    public void removeByName(E dataItem)
    {
        if (size == 0)
        {
            throw new NoSuchElementException();
        }

        Node temp = head;
        boolean searchFlag = true;

        while (searchFlag)
        {
            if (temp.dataItem == dataItem)
            {
                System.out.println("Deleting " + temp.dataItem);
                temp.next = temp.next.next;
                temp.prev = temp.prev.prev;
                size--;
                searchFlag = false;
            }

            if (temp == null)
            {
                System.out.println("Couldn't find that data...");
                searchFlag = false;
            }

            else
            {
                temp = temp.next;
            }
        }
    }

    //Removes the item at the front of the list.
    public void removeFromFront()
    {
        if (size == 0)
        {
            throw new NoSuchElementException();
        }

        Node temp = head;
        head = head.next;
        head.prev = null;
        size--;

        System.out.println("Removed " + temp.dataItem + " from the front of the list.");
    }

    //Prints the list.
    public void printList()
    {
        Node temp = head;

        for (int i = 0; i < size; i++)
        {
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }
}
