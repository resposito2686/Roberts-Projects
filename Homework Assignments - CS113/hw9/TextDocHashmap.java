package edu.miracosta.cs113.hw9;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.Scanner;

public class TextDocHashmap
{
    public static void main(String[] args)
    {
        HashMap<String, Integer> map = (HashMap)scanDoc();

        System.out.println("--- HashMap of the text document ---");
        displayHashmap(map);

        Word[] wordArray = makeArray(map);
        System.out.println("\n\n\n--- Array sorted by frequency ---");
        sortArrayByCount(wordArray);
    }

    public static Map<String, Integer> scanDoc()
    {
        Map<String, Integer> hashMap = new HashMap<String, Integer>();
        Scanner input;

        try
        {
          input = new Scanner(new FileInputStream("/Users/rjesposito86/IdeaProjects/cs113_Esposito_Robert/src/edu/miracosta/cs113/hw9/TestDoc.txt"));
          input.useDelimiter(".");
          input.useDelimiter("\"");
          input.useDelimiter(",");
          input.useDelimiter(";");

          while (input.hasNextLine())
          {
              String word = input.findInLine("[\\p{L}\\p{N}']+");

              while (word != null)
              {
                  word = word.toUpperCase();
                  Integer count = hashMap.get(word);

                  if (count == null)
                  {
                      hashMap.put(word, 1);
                  }

                  else
                  {
                      hashMap.put(word, ++count);
                  }

                  word = input.findInLine("[\\p{L}\\p{N}']+");
              }

              input.nextLine();
          }

          input.close();
        }

        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }

        return hashMap;
    }

    public static void displayHashmap(Map<String, Integer> hashMap)
    {
        for (Map.Entry<String, Integer> m : hashMap.entrySet())
        {
            System.out.println(m.getKey() + " : " + m.getValue());
        }
    }

    public static Word[] makeArray(Map<String, Integer> hashMap)
    {
        Set<Map.Entry<String, Integer>> tempMap = hashMap.entrySet();
        Word[] mapArray = new Word[tempMap.size()];
        int i = 0;

        for (Map.Entry<String, Integer> m : tempMap)
        {
            mapArray[i] = new Word(m.getKey(), m.getValue());
            i++;
        }
        return mapArray;
    }

    public static void sortArrayByCount (Word[] wordArray)
    {
        Arrays.sort(wordArray);

        for (Word a : wordArray)
        {
            System.out.println(a.getWord() + " : " + a.getCount());
        }
    }
}