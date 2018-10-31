package edu.miracosta.cs113.hw5.part1;

/** Stores the name of the compnay and how many widgets they are ordering */
public class Order
{
    private String companyName;
    private int quantity;

    public Order(String companyName, int quantity)
    {
        this.companyName = companyName;
        this.quantity = quantity;
    }

    public String getCompanyName()
    {
        return companyName;
    }

    public void setCompanyName(String companyName)
    {
        this.companyName = companyName;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (quantity != order.quantity) return false;
        return companyName != null ? companyName.equals(order.companyName) : order.companyName == null;
    }

    public String toString()
    {
        return "\n" + companyName + "\nQuantity: " + quantity;
    }
}


