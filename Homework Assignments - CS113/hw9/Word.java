package edu.miracosta.cs113.hw9;


public class Word implements Comparable<Word>
{
    private String word;
    private int count;

    public Word(String word, int count)
    {
        this.word = word;
        this.count = count;
    }

    public Word()
    {
        this.word = null;
        this.count = 0;
    }

    public String getWord()
    {
        return word;
    }

    public int getCount()
    {
        return count;
    }

    public String toString()
    {
        return word + " : " + count;
    }

    public int compareTo(Word otherword)
    {
        int compareCount = otherword.getCount();
        return compareCount - this.count;
    }
}
