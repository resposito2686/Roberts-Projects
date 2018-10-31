package edu.miracosta.cs113.hw5.part1;

/* Programmed By : Robert Esposito
   Date          : 03/5/17
   Class         : CS 113, Monday @ 5:30PM
   Assignment    : Homework #5

   Description: This program will create 2 stacks. One for Widgets and
   one for Orders. It accepts a shipment of widgets, which is a random
   quantity (between 1 and 10), and assigns them a name and a price. It
   accepts an order, which requires a random number of widgets (between
   1 and 10) to fill. It fills the next order in the stack, unless there
   are no orders to be filled. If there aren't enough widgets to fill the
   order, it does not get filled.

 */
import java.util.InputMismatchException;
import java.util.Scanner;

public class OrderProcessing
{
    static RandomGenerator rand = new RandomGenerator();
    static int widgetCount;
    static int orderCount;
    static double totalProfit;

    public static void main(String[] args)
    {
        WidgetStack<Widget> widgets = new WidgetStack<>();
        WidgetStack<Order> orders = new WidgetStack<>();

        boolean menuFlag = true;

        while (menuFlag)
        {
            printMenu();
            int menuSelect = menuInput();

            switch (menuSelect)
            {
                /** Adds Widget objects to the widgets stack. */
                case 1:
                    int numInOrder = rand.getNumber();

                    System.out.println("Accepting an order of " + numInOrder + " Widgets...");
                    widgetCount += numInOrder;

                    for (int i = 0; i < numInOrder; i++)
                    {
                        widgets.push(new Widget(rand.getWidgetName(), rand.getPrice()));
                    }
                    System.out.println(numInOrder + " Widgets added. " + widgetCount + " total Widgets.");
                    break;

                /** Adds an Order object to the orders stack */
                case 2:
                    numInOrder = rand.getNumber();

                    System.out.println("Adding new order for " + numInOrder + " Widgets...");

                    orders.push(new Order(rand.getCompanyName(), numInOrder));
                    orderCount++;

                    System.out.println("Order Added. " + orderCount + " total Orders.");
                    break;

                /** If the orders stack is empty or there aren't enough widgets to fill the order,
                 *  outputs information to user.
                 *  Pops the order and the appropriate number of widgets otherwise. Also calculates how
                 *  much money was made on the order.
                 */
                case 3:

                    if (orders.empty())
                    {
                        System.out.println("No orders to fill.");
                        break;
                    }

                    else if (orders.peek().getQuantity() > widgetCount)
                    {
                        System.out.println("Not enough widgets to fill the current order: ");
                        System.out.println(orders.peek().toString());
                        System.out.println((orders.peek().getQuantity() - widgetCount) + " widgets " +
                                "needed to fill order.");
                        break;
                    }

                    else
                    {
                        double profit = 0;
                        for (int i = 0; i < orders.peek().getQuantity(); i++)
                        {
                            profit += (widgets.peek().getCost() * 0.5);
                            widgets.pop();
                            widgetCount--;
                        }
                        totalProfit += profit;

                        System.out.println("Order filled: ");
                        System.out.println(orders.peek().toString());

                        orders.pop();
                        orderCount--;

                        System.out.println("Order profit: $" + profit);
                        System.out.println("Total profit: $" + totalProfit);
                    }
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Please make a valid menu selection.");
                    break;
            }
        }
    }

    /** Outputs the menu to the user */
    static void printMenu()
    {
        System.out.println("*-------- Widget Orders --------*");
        System.out.println("* <1> Accept Widget Shipment     ");
        System.out.println("* <2> Accept Order               ");
        System.out.println("* <3> Fill Next Order            ");
        System.out.println("* <4> Exit Program               ");
    }

    /** Returns integer entered by the user. Throws exception if integer is not entered */
    static int menuInput()
    {
        int menuInput = 0;
        Scanner keyboard = new Scanner(System.in);

        try
        {
            menuInput = keyboard.nextInt();
        }

        catch (InputMismatchException e)
        {
            System.out.println("Please enter a number.");
        }

        return menuInput;
    }
}
