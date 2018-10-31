package edu.miracosta.cs113.hw8.part1;

public class BinaryTree<E>
{
    /** Node class for the Binary Tree */
    protected class Node
    {
        Node left;
        Node right;
        E data;

        Node (E data)
        {
            this.data = data;
        }

        public String toString()
        {
            return data.toString();
        }
    }

    /** Iterator class for the Binary Tree. Uses inOrder traversal */
    class Iterator implements java.util.Iterator
    {
        IteratorStack<Node> stack;

        public Iterator(Node root)
        {
            stack = new IteratorStack<>();

            while (root != null)
            {
                stack.push(root);
                root = root.left;
            }
        }

        public boolean hasNext()
        {
            return !stack.empty();
        }

        public E next()
        {
            Node focus = stack.pop();
            E result = focus.data;

            if (focus.right != null)
            {
                focus = focus.right;
                while (focus != null)
                {
                    stack.push(focus);
                    focus = focus.left;
                }
            }
            return result;
        }
    }

    Node root;

    public BinaryTree()
    {
        this.root = null;
    }

    public BinaryTree(Node root)
    {
        this.root = root;
    }

    /** Adds a node to the Binary Tree at the first available location */
    public void addNode (E data)
    {
        Node tempNode = new Node(data);

        if (root == null)
        {
            root = tempNode;
        }

        else
        {
            Node focus = root;
            Node parent;
            boolean addFlag = true;

            while (addFlag)
            {
                parent = focus;

                if (focus.left == null)
                {
                    focus = focus.left;

                    if (focus == null)
                    {
                        parent.left = tempNode;
                        addFlag = false;
                    }
                }

                else
                {
                    focus = focus.right;

                    if (focus == null)
                    {
                        parent.right = tempNode;
                        addFlag = false;
                    }
                }
            }
        }
    }

    /** Traverses the tree using Breadth-First traversal */
    public void breadthFirstTraverse()
    {
        BreadthFirstQueue<Node> queue = new BreadthFirstQueue<>();

        if (root == null)
        {
            System.out.println("Empty tree");
        }

        else
        {
            queue.offer(root);

            while (!queue.empty())
            {
                Node temp = queue.remove();
                System.out.println(temp.toString());

                if (temp.left != null)
                {
                    queue.add(temp.left);
                }

                if (temp.right != null)
                {
                    queue.add(temp.right);
                }
            }
        }
    }

    /** Traverses the tree using the interator class */
    public E useIterator()
    {
        Iterator it = new Iterator(root);

        while (it.hasNext())
        {
            return it.next();
        }

        return null;
    }
}
