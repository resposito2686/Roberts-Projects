package edu.miracosta.cs113.hw2.part4;

public class Sushi extends Food
{
    public Sushi()
    {
        super.setCalories(255.0);
    }

    public double percentFat()
    {
        double gramsOfFat = 7.0;
        double fat = gramsOfFat * 9;

        return (fat/super.getCalories()) * 100;
    }

    public double percentProtein()
    {
        double gramsOfProtein = 9.0;
        double protein = gramsOfProtein * 4;

        return (protein/super.getCalories()) * 100;
    }

    public double percentCarbohydrates()
    {
        double gramsOfCarbs = 38.0;
        double carbs = gramsOfCarbs * 4;

        return (carbs/super.getCalories()) * 100;
    }

    public String toString()
    {
        return " *** Sushi ***\nTotal Calories: 255\nPercent from Fat: " + (int)percentFat()
                + "%\nPercent from Protein: " + (int)percentProtein() + "%\nPercent from Carbs: "
                + (int)percentCarbohydrates() + "%\n\n";
    }
}
