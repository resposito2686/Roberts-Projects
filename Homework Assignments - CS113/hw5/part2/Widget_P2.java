package edu.miracosta.cs113.hw5.part2;

/** Stores the name of the widget along with it's cost. */
public class Widget_P2
{
    private String name;
    private double cost;

    public Widget_P2(String name, double cost)
    {
        this.name = name;
        this.cost = cost;
    }

    public Widget_P2()
    {
        name = "Unknown";
        cost = 0.0;
    }

    public String getName()
    {
        return name;
    }

    public double getCost()
    {
        return cost;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCost(double cost)
    {
        this.cost = cost;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Widget_P2 widgetP2 = (Widget_P2) o;

        if (Double.compare(widgetP2.cost, cost) != 0) return false;
        return name != null ? name.equals(widgetP2.name) : widgetP2.name == null;
    }

    public String toString()
    {
        return "\nName: " + name + "\nCost: " + cost;
    }
}
