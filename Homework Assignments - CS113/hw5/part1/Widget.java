package edu.miracosta.cs113.hw5.part1;

/** Stores the name of the widget along with it's cost. */
public class Widget
{
    private String name;
    private double cost;

    public Widget (String name, double cost)
    {
        this.name = name;
        this.cost = cost;
    }

    public Widget()
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

        Widget widget = (Widget) o;

        if (Double.compare(widget.cost, cost) != 0) return false;
        return name != null ? name.equals(widget.name) : widget.name == null;
    }

    public String toString()
    {
        return "\nName: " + name + "\nCost: " + cost;
    }
}
