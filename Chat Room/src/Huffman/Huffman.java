package Huffman;

import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Scanner;


public class Huffman {

    static PriorityQueue<Node> nodes = new PriorityQueue<>((o1, o2) -> (o1.value < o2.value) ? -1 : 1);
    static TreeMap<Character, String> codes = new TreeMap<>();
    static String text = "";
    static String bitCode = "";
    static String decodedStr = "";
    static int asciiTable[] = new int[128];

    //goes through message and assigns weight depending on count
    //adds to lookup table
    private static void countChar(PriorityQueue<Node> s)
    {
        for (int i = 0; i < text.length(); i++)
        {
            asciiTable[text.charAt(i)]++;
        }
        for (int i = 0; i < asciiTable.length; i++)
        {
            if (asciiTable[i] > 0)
            {
                s.add(new Node(asciiTable[i] / (text.length() * 1.0), ((char) i) + ""));
            }
        }
    }

    //builds tree depending on weight
    private static void buildTree(PriorityQueue<Node> s)
    {
        while (s.size() > 1)
        {
            s.add(new Node(s.poll(), s.poll()));
        }
    }

    //goes through code and looks up tree to find correct char
    private static void decompress()
    {
        Node node = nodes.peek();
        for (int i = 0; i < bitCode.length(); )
        {
            Node tempN = node;
            while (tempN.left != null && tempN.right != null && i < bitCode.length())
            {
                if (bitCode.charAt(i) == '1')
                {
                    tempN = tempN.right;
                }
                else
                {
                    tempN = tempN.left;
                }

                i++;
            }
            if (tempN != null && tempN.character.length() == 1)
            {
                decodedStr += tempN.character;
            }

        }
    }

    //access map of chars and puts together a string, call AFTER compress
    private static void getCode()
    {
        for (int i = 0; i < text.length(); i++)
        {
            bitCode += codes.get(text.charAt(i));
        }
    }

    //goes through tree and adds chars to map
    private static void compress(Node node, String s)
    {
        if (node != null)
        {
            if (node.right != null)
            {
                compress(node.right, s + "1");
            }
            if (node.left != null)
            {
                compress(node.left, s + "0");
            }
            if (node.left == null && node.right == null)
            {
                codes.put(node.character.charAt(0), s);
            }
        }
    }


    //**MAIN METHOD** you can comment this out!! use this to see how to run through the huffman

    public static void main(String[] args)
    {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter text to compress: ");
        text = scnr.nextLine();
        countChar(nodes);
        System.out.println("weight of each char: ");
        for(int i = 0; i < asciiTable.length; i++)
        {
            if (asciiTable[i] > 0)
            {
                System.out.println("'" + ((char) i) + "' --> " + asciiTable[i] / (text.length() * 1.0));
            }
        }
        buildTree(nodes);
        compress(nodes.peek(), "");
        System.out.println("bit code of each char: ");
        codes.forEach((k, v) -> System.out.println("'" + k + "' -->  " + v)); // print TreeMap out
        getCode();
        System.out.println("encoded text: " + bitCode);
        decompress();
        System.out.println("decoded text: " + decodedStr);
    }
}