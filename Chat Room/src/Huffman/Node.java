package Huffman;


//Simple node class to form a simple tree
class Node
{
    Node left;
    Node right;
    double value;
    String character;

    public Node(double value, String theChar)
    {
        this.value = value;
        this.character = theChar;
        left = null;
        right = null;
    }

    public Node(Node left, Node right)
    {
        this.value = left.value + right.value;
        character = left.character + right.character;
        if (left.value < right.value)
        {
            this.right = right;
            this.left = left;
        }
        else
        {
            this.right = left;
            this.left = right;
        }
    }
}