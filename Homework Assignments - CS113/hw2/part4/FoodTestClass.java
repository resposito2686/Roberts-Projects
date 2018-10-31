package edu.miracosta.cs113.hw2.part4;

/* Programmed By : Robert Esposito
   Date          : 02/05/17
   Class         : CS 113, Monday @ 5:30PM
   Assignment    : Homework #2

   Description: This program will create objects of my
   favorite foods. The program will then calculate the
   amount of calories each food item gets from Fat, Protein,
   and Carbs. They all extend the abstract class called
   Food. The objects will be put into an ArrayList and
   printed in a for:each loop.

 */

import java.util.ArrayList;

public class FoodTestClass
{
    public static void main(String[] args)
    {
        ArrayList<Food> food = new ArrayList<>();

        food.add(new Pizza());
        food.add(new Burrito());
        food.add(new Sushi());
        food.add(new Ramen());
        food.add(new Burger());

        System.out.println("\n::::: Food Items :::::\n");
        for (Food object: food)
        {
            System.out.println(object);
        }
    }
}
