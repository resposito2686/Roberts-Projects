package edu.miracosta.cs113.hw2.part4;

public class Ramen extends Food
{
    public Ramen()
    {
        super.setCalories(188.0);
    }

    public double percentFat()
    {
        double gramsOfFat = 7.0;
        double fat = gramsOfFat * 9;

        return (fat/super.getCalories()) * 100;
    }

    public double percentProtein()
    {
        double gramsOfProtein = 4.5;
        double protein = gramsOfProtein * 4;

        return (protein/super.getCalories()) * 100;
    }

    public double percentCarbohydrates()
    {
        double gramsOfCarbs = 27.0;
        double carbs = gramsOfCarbs * 4;

        return (carbs/super.getCalories()) * 100;
    }

    public String toString()
    {
        return " *** Ramen ***\nTotal Calories: 188\nPercent from Fat: " + (int)percentFat()
                + "%\nPercent from Protein: " + (int)percentProtein() + "%\nPercent from Carbs: "
                + (int)percentCarbohydrates() + "%\n\n";
    }
}
