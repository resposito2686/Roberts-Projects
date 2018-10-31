package edu.miracosta.cs113.hw3.part1;


public class Assignment
{
    private String assignmentName;
    private String dueDate;

    public Assignment(String assignmentName, String dueDate)
    {
        this.assignmentName = assignmentName;
        this.dueDate = dueDate;
    }

    public void setAssignmentName(String assignmentName)
    {
        this.assignmentName = assignmentName;
    }

    public String getAssignmentName()
    {
        return assignmentName;
    }

    public void setDueDate(String dueDate)
    {
        this.dueDate = dueDate;
    }

    public String getDueDate()
    {
        return dueDate;
    }

    //parses the month into an int for comparison.
    public int getDueDateMonth()
    {
        String month = dueDate.substring(0,2);
        int m = Integer.parseInt(month);
        return m;
    }

    //parses the day into an int for comparison.
    public int getDueDateDay()
    {
        String day = dueDate.substring(3,5);
        int d = Integer.parseInt(day);
        return d;
    }

    //parses the year into an int for comparison.
    public int getDueDateYear()
    {
        String year = dueDate.substring(6);
        int y = Integer.parseInt(year);
        return y;
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

        Assignment e = (Assignment) obj;

        return assignmentName.equals(e.assignmentName);
    }

    public String toString()
    {
        return "\nName: " + assignmentName + "\nDue Date: " + dueDate;
    }
}
