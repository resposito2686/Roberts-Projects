package edu.miracosta.cs113.hw8.part1;

/* Programmed By : Robert Esposito
   Date          : 04/10/17
   Class         : CS 113, Monday @ 5:30PM
   Assignment    : Homework #8

   Description: This program will implement a Binary Tree class.
   It will then traverse the tree using breadth-first traversal
   and then using an iterator.

 */

public class BinaryTreeTester
{
    public static void main(String[] args)
    {

        BinaryTree<Character> tree = new BinaryTree<>();

        tree.addNode('a');
        tree.addNode('b');
        tree.addNode('c');
        tree.addNode('d');
        tree.addNode('e');
        tree.addNode('f');
        tree.addNode('g');

        tree.breadthFirstTraverse();
        System.out.println();
        System.out.println(tree.useIterator());

    }
}
