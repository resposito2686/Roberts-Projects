package edu.miracosta.cs113.hw2.part4;


//Parent class
public abstract class Food
{
    private double calories;

    public abstract double percentProtein();
    public abstract double percentFat();
    public abstract double percentCarbohydrates();

    public void setCalories(double calories)
    {
        this.calories = calories;
    }

    public double getCalories()
    {
        return calories;
    }

}
