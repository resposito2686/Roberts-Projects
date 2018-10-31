package edu.miracosta.cs113.hw11.lab1;

public class RebalanceRight
{
    public static void main(String[] args)
    {
        System.out.println("Right re-balance of AVL tree");
    }

    /*
    private AVLNode<E> rebalanceRight(AVLNode<E> localRoot)
    {
        AVLNode<E> rightChild = (AVLNode<E>) localRoot.right;

        if (rightChild.balance > AVLNode.BALANCED)
        {
            AVLNode<E> rightLeftChild = (AVLNode<E>) rightChild.left;

            if(rightLeftChild.balance < AVLNode.BALANCED)
            {
                rightChild.balance < AVLNode.BALANCED;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.LEFT_HEAVY;
            }
            else
            {
                rightChild.balance = AVLNode.RIGHT_HEAVY;
                rightLeftChild.balance = AVLNode.BALANCED;
                localRoot.balance = AVLNode.BALANCED;
            }

            localRoot.right = rotateRight(rightChild);
        }
        else
        {
            rightChild.balance = AVLNode.BALANCED;
            localRoot.balance = AVLNode.BALANCED;
        }

        return (AVLNode<E>) rotateLeft(localRoot);
    }
     */
}
