package edu.miracosta.cs113.hw2.part4;

public class Pizza extends Food
{
    public Pizza()
    {
        super.setCalories(285.0);
    }

    public double percentFat()
    {
        double gramsOfFat = 10.0;
        double fat = gramsOfFat * 9;

        return (fat/super.getCalories()) * 100;
    }

    public double percentProtein()
    {
        double gramsOfProtein = 12.0;
        double protein = gramsOfProtein * 4;

        return (protein/super.getCalories()) * 100;
    }

    public double percentCarbohydrates()
    {
        double gramsOfCarbs = 12.0;
        double carbs = gramsOfCarbs * 4;

        return (carbs/super.getCalories()) * 100;
    }

    public String toString()
    {
        return " *** Pizza ***\nTotal Calories: 285\nPercent from Fat: " + (int)percentFat()
                + "%\nPercent from Protein: " + (int)percentProtein() + "%\nPercent from Carbs: "
                + (int)percentCarbohydrates() + "%\n\n";
    }
}