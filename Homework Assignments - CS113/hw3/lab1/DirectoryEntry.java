package edu.miracosta.cs113.hw3.lab1;

public class DirectoryEntry
{
    private String name;
    private String number;

    public DirectoryEntry(String name, String number)
    {
        this.name = name;
        this.number = number;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public String getNumber()
    {
        return number;
    }

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }

        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }

        DirectoryEntry d = (DirectoryEntry) obj;

        return name.equals(d.name);
    }

    public String toString()
    {
        return "\nName: " + name + "\nNumber: " + number;
    }
}
