package edu.miracosta.cs113.hw2.part4;

public class Burger extends Food
{
    public Burger()
    {
        super.setCalories(670.0);
    }

    public double percentFat()
    {
        double gramsOfFat = 41.0;
        double fat = gramsOfFat * 9;

        return (fat/super.getCalories()) * 100;
    }

    public double percentProtein()
    {
        double gramsOfProtein = 37.0;
        double protein = gramsOfProtein * 4;

        return (protein/super.getCalories()) * 100;
    }

    public double percentCarbohydrates()
    {
        double gramsOfCarbs = 39.0;
        double carbs = gramsOfCarbs * 4;

        return (carbs/super.getCalories()) * 100;
    }

    public String toString()
    {
        return " *** Burger ***\nTotal Calories: 670\nPercent from Fat: " + (int)percentFat()
                + "%\nPercent from Protein: " + (int)percentProtein() + "%\nPercent from Carbs: "
                + (int)percentCarbohydrates() + "%\n\n";
    }
}
