package edu.miracosta.cs113.hw6.part1;

import java.util.Random;

public class PrintJob
{
    Random rand = new Random();
    private int pages;

    public PrintJob()
    {
        pages = rand.nextInt(50) + 1;
    }

    public int getPages()
    {
        return pages;
    }
}
