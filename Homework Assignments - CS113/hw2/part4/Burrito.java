package edu.miracosta.cs113.hw2.part4;

public class Burrito extends Food
{

    public Burrito()
    {
        super.setCalories(910.0);
    }

    public double percentFat()
    {
        double gramsOfFat = 37.0;
        double fat = gramsOfFat * 9;

        return (fat/super.getCalories()) * 100;
    }

    public double percentProtein()
    {
        double gramsOfProtein = 40.5;
        double protein = gramsOfProtein * 4;

        return (protein/super.getCalories()) * 100;
    }

    public double percentCarbohydrates()
    {
        double gramsOfCarbs = 101.0;
        double carbs = gramsOfCarbs * 4;

        return (carbs/super.getCalories()) * 100;
    }

    public String toString()
    {
        return " *** Burrito ***\nTotal Calories: 910\nPercent from Fat: " + (int)percentFat()
                + "%\nPercent from Protein: " + (int)percentProtein() + "%\nPercent from Carbs: "
                + (int)percentCarbohydrates() + "%\n\n";
    }
}
