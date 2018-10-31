package edu.miracosta.cs113.hw5.part2;

/** Stores the name of the compnay and how many widgets they are ordering */
public class Order_P2
{
    private String companyName;
    private int quantity;

    public Order_P2(String companyName, int quantity)
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

        Order_P2 orderP2 = (Order_P2) o;

        if (quantity != orderP2.quantity) return false;
        return companyName != null ? companyName.equals(orderP2.companyName) : orderP2.companyName == null;
    }

    public String toString()
    {
        return "\n" + companyName + "\nQuantity: " + quantity;
    }
}


