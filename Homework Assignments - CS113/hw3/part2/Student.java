package edu.miracosta.cs113.hw3.part2;

public class Student
{
    private String name;
    private String idNumber;

    public Student(String name, String idNumber)
    {
        this.name = name;
        this.idNumber = idNumber;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setIdNumber(String idNumber)
    {
        this.idNumber = idNumber;
    }

    public String getIdNumber()
    {
        return idNumber;
    }

    public String toString()
    {
        return "\nName: " + name + "\nID Number: " + idNumber;
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

        Student e = (Student) obj;

        return name.equals(e.name);
    }
}
