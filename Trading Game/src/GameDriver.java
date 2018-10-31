/* ROBERT ESPOSITO - CS 112 TUE & TH @ 1:30
 * DECEMBER 12TH, 2016
 * FINAL PROJECT
 * GameDriver.java
 * 
 * Algorithm:
 * 
 * 1. CREATE A CLASS CALLED GAME. THIS WILL STORE THE PLAYERS MONEY, ITEMS AND
 * KEEP TRACK OF HOW MANY DAYS HAVE PASSED IN THE GAME. THE CONSTRUCTOR WILL ALSO ASK
 * THE USER FOR THEIR NAME.
 * 
 * 2. THE GAME CLASS WILL HAVE METHODS TO INCREMENT THE DAYS, AS WELL AS ADD, SUBTRACT, AND
 * RETURN MONEY AND ITEMS
 * 
 * 3. CREATE A MAIN THAT WILL RUN EACH GAME SESSION.
 * 
 * 4. CREATE A STATIC OBJECT OF TYPE GAME SO THE PLAYERS MONEY AND ITEMS CAN BE KEPT TRACK
 * OF FOR THE ENTIRE GAME.
 * 
 * 5. CREATE A METHOD THAT WILL GENERATE A RANDOM NUMBER BETWEEN A GIVEN RANGE. THIS WILL BE
 * USED TO SET THE PRICE ON EACH ITEM IN EACH CITY THE PLAYER TRAVELS TO.
 *
 * 6. CRATE A METHOD THAT WILL HANDLE ALL INTEGER KEYBOARD INPUT. THE METHOD WILL CATCH ANY
 * INPUTMISMATCH EXCEPTIONS AND ASK THE USER TO ENTER AGAIN.
 * 
 * 7. CREATE A METHOD THAT WILL HOLD THE INFORMATION FOR EACH CITY. THIS METHOD WILL DISPLAY THE
 * CITIES NAME AND THE PRICE OF THE ITEMS THE CITY IS SELLING.
 * 
 * 8. IN THE SAME CITY METHOD, WRITE A SWITCH STATEMENT THAT WILL ACT AS A MENU FOR THE USER.
 * IT WILL ALLOW THEM TO BUY OR SELL GOODS, OR TRAVEL TO A NEW CITY.
 * 
 * 9. IF THEY CHOSE BUY, IT WILL GO TO AN INNER SWITCH STATEMENT THAT WILL ASK THEM WHICH ITEM
 * THEY WANT TO BUY. ONCE THEY HAVE CHOSEN AN ITEM, IT WILL ASK THEM HOW MANY THEY WOULD LIKE TO BUY,
 * ALONG WITH HOW MANY THEY CAN AFFORD. 
 * 		IF THEY TRY TO BUY MORE THAN THEY CAN, IT WILL PRINT AN ERROR AND ASK THEM TO ENTER THE 
 * 		AMOUNT AGAIN.
 * 
 * 		IF THEY DO HAVE ENOUGH MONEY, IT WILL ADD THE AMOUNT TO THE CORRESPONDING VARIABLE IN
 * 		THE GAME CLASS AND SUBTRACT THE APPROPRIATE AMOUNT OF MONEY FROM THE MONEY VARIABLE.
 * 
 * 10. IF THEY CHOSE SELL, IT WILL GO TO AN INNER SWITCH STATEMENT THAT WILL ASK THEM WHICH ITEM
 * THEY WANT TO SELL. ONCE THEY HAVE CHOSEN AN ITEM, IT WILL ASK THEM HOW MANY THEY WOULD LIKE TO SELL,
 * ALONG WITH HOW MANY THEY CURRENTLY HAVE.
 * 		IF THEY TRY TO SELL MORE THAN THEY HAVE, IT WILL PRINT AN ERROR AND ASK THEM TO ENTER THE
 * 		AMOUNT AGAIN.
 * 
 * 		OTHERWISE, IT WILL SUBTRACT THE AMOUNT THE CHOSE TO SELL FROM THE CORRESPONDING VARIABLE
 * 		IN THE GAME CLASS AND ADD THE APPROPRIATE AMOUNT OF MONEY FROM THE MONEY VARIABLE.
 * 
 * 11. ONCE THE PERSON HAS TRAVELED 30 TIMES, THE GAME WILL END.
 * 
 * 12. WHEN THE GAME ENDS, IT WILL WRITE THE USERS MONEY AND NAME TO A FILE.
 * 
 * 13. THE GAME WILL ALSO DISPLAY ALL THE PREVIOUS HIGH SCORES. IT WILL ADD ALL THE LINES OF THE FILE
 * TO AN ARRAYLIST (THAT WAY IT CAN ADD ALL THE LINES OF THE FILE NO MATTER HOW MANY THERE ARE). IT
 * CONVERTS THE ARRAYLIST TO A REGULAR ARRAY AND SORTS IT USING A BUBBLESORT METHOD. ONCE SORTED, IT
 * WILL DISPLAY THE HIGH SCORES IN DECENDING ORDER TO THE USER.
 */

import java.util.*;
import java.util.Random;
import java.io.*;

public class GameDriver
{
    //Creates a new game when the program is launched.
    private static Game game = new Game();

    public static void main(String[] args)
    {
        boolean gameLoop = true;
        printTitle();

        //Loops the program until 30 days have passed.
        while(gameLoop)
        {
            System.out.println("Where do you want to go?");
            printCityNames();

            int citySwitch = intInput();

            //City Selection.
            switch(citySwitch)
            {
                case 1:
                    makeCity("Constantinople");
                    game.addDay();
                    break;

                case 2:
                    makeCity("Rome");
                    game.addDay();
                    break;

                case 3:
                    makeCity("Bombay");
                    game.addDay();
                    break;

                case 4:
                    makeCity("Alexandria");
                    game.addDay();
                    break;

                case 5:
                    makeCity("Aleppo");
                    game.addDay();
                    break;

                case 6:
                    makeCity("Xi'an");
                    game.addDay();
                    break;

                default:
                    break;
            }

            //Ends game once 30 days have been reached.
            if (game.getDays() >= 30)
                gameLoop = false;
        }

        System.out.println("\n\n\n\n\n\n");
        System.out.println("------ Game Over ------");
        System.out.println("Saving high score...");
        System.out.println("\n\n\n");
        writeHighScore();
        printHighScore();


    }
    /* This method creates each city and assigns a numeric value to the goods
       that are sold in the city. It also houses the buying and selling portions
       of the game. */
    private static void makeCity(String name)
    {
        int optionsSwitch;
        int buySwitch;
        int sellSwitch;
        int amount;
        int tempPrice;
        drawBoard(name);

        //Generates a random number in a range for each item.
        int gold = randInt(5000,7000);
        System.out.println("Gold: " + gold + " (" + game.getGoldAmt() + ")");
        int silver = randInt(150,250);
        System.out.println("Silver: " + silver + " (" + game.getSilverAmt() + ")");
        int silk = randInt(30,50);
        System.out.println("Silk: " + silk + " (" + game.getSilkAmt() + ")");
        int diamond = randInt(15000,20000);
        System.out.println("Diamond: " + diamond + " (" + game.getDiamondAmt() + ")");
        int ivory = randInt(1000,1500);
        System.out.println("Ivory: " + ivory + " (" + game.getIvoryAmt() + ")");
        int tea = randInt(1,10);
        System.out.println("Tea: " + tea + " (" + game.getTeaAmt() + ")");

        printOptions();

        optionsSwitch = intInput();

        /* First switch statement lets the user choose between buying, selling, or traveling */
        switch (optionsSwitch)
        {
            case 1: //Buying Items
                System.out.println("What would you like to buy?");
                printBuySell();
                buySwitch = intInput();

                switch (buySwitch)
                {
                    case 1: //gold
                        System.out.println("How many would you like to buy? (you can afford " + game.getMoney()/gold + ")");
                        amount = intInput();
                        tempPrice = gold*amount;

                        try
                        {
                            if (game.getMoney()/tempPrice < 1)
                            {
                                System.out.println("You cannot afford that many");
                            }

                            else
                            {
                                game.addGoldAmt(amount);
                                game.subMoney(tempPrice);
                                System.out.println("Bought " + amount + " gold for a cost of: " + tempPrice);
                            }
                        }

                        catch (ArithmeticException e)
                        {
                            System.out.println("No gold purchased");
                            break;
                        }
                        break;

                    case 2: //silver
                        System.out.println("How many would you like to buy? (you can afford " + game.getMoney()/silver + ")");
                        amount = intInput();
                        tempPrice = silver*amount;

                        try
                        {
                            if (game.getMoney()/tempPrice < 1)
                            {
                                System.out.println("You cannot afford that many");
                            }

                            else
                            {
                                game.addSilverAmt(amount);
                                game.subMoney(tempPrice);
                                System.out.println("Bought " + amount + " silver for a cost of: " + tempPrice);
                            }
                        }
                        catch (ArithmeticException e)
                        {
                            System.out.println("No silver purchased");
                            break;
                        }
                        break;

                    case 3: //silk
                        System.out.println("How many would you like to buy? (you can afford " + game.getMoney()/silk + ")");
                        amount = intInput();
                        tempPrice = silk*amount;

                        try
                        {
                            if (game.getMoney()/tempPrice < 1)
                            {
                                System.out.println("You cannot afford that many");
                            }

                            else
                            {
                                game.addSilkAmt(amount);
                                game.subMoney(tempPrice);
                                System.out.println("Bought " + amount + " silk for a cost of: " + tempPrice);
                            }
                        }

                        catch (ArithmeticException e)
                        {
                            System.out.println("No silk purchased");
                            break;
                        }
                        break;

                    case 4: //diamond
                        System.out.println("How many would you like to buy? (you can afford " + game.getMoney()/diamond + ")");
                        amount = intInput();
                        tempPrice = diamond*amount;

                        try
                        {
                            if (game.getMoney()/tempPrice < 1)
                            {
                                System.out.println("You cannot afford that many");
                            }

                            else
                            {
                                game.addDiamondAmt(amount);
                                game.subMoney(tempPrice);
                                System.out.println("Bought " + amount + " diamond for a cost of: " + tempPrice);
                            }
                        }
                        catch (ArithmeticException e)
                        {
                            System.out.println("No diamond purchased");
                            break;
                        }
                        break;

                    case 5: //ivory
                        System.out.println("How many would you like to buy? (you can afford " + game.getMoney()/ivory + ")");
                        amount = intInput();
                        tempPrice = ivory*amount;

                        try
                        {
                            if (game.getMoney()/tempPrice < 1)
                            {
                                System.out.println("You cannot afford that many");
                            }

                            else
                            {
                                game.addIvoryAmt(amount);
                                game.subMoney(tempPrice);
                                System.out.println("Bought " + amount + " ivory for a cost of: " + tempPrice);
                            }
                        }

                        catch (ArithmeticException e)
                        {
                            System.out.println("No ivory purchased");
                            break;
                        }
                        break;

                    case 6: //tea
                        System.out.println("How many would you like to buy? (you can afford " + game.getMoney()/tea + ")");
                        amount = intInput();
                        tempPrice = tea*amount;

                        try
                        {
                            if (game.getMoney()/tempPrice < 1)
                            {
                                System.out.println("You cannot afford that many");
                            }

                            else
                            {
                                game.addTeaAmt(amount);
                                game.subMoney(tempPrice);
                                System.out.println("Bought " + amount + " tea for a cost of: " + tempPrice);
                            }
                        }

                        catch (ArithmeticException e)
                        {
                            System.out.println("No tea purchased");
                            break;
                        }
                        break;
                    default:
                        break;
                }
                break;


            case 2: //Selling items
                System.out.println("What would you like to sell?");
                printBuySell();
                sellSwitch = intInput();

                switch (sellSwitch)
                {
                    case 1: //gold
                        System.out.println("How many would you like to sell? (you have " + game.getGoldAmt() + ")");
                        amount = intInput();
                        tempPrice = gold*amount;

                        if (amount < game.getGoldAmt())
                        {
                            System.out.println("You don't have that many to sell");
                        }

                        else
                        {
                            game.subGoldAmt(amount);
                            game.addMoney(tempPrice);
                            System.out.println("Sold " + amount + " gold for a profit of: " + tempPrice);
                        }
                        break;

                    case 2: //silver
                        System.out.println("How many would you like to sell? (you have " + game.getSilverAmt() + ")");
                        amount = intInput();
                        tempPrice = silver*amount;

                        if (amount < game.getSilverAmt())
                        {
                            System.out.println("You don't have that many to sell");
                        }

                        else
                        {
                            game.subSilverAmt(amount);
                            game.addMoney(tempPrice);
                            System.out.println("Sold " + amount + " silver for a profit of: " + tempPrice);
                        }
                        break;

                    case 3: //silk
                        System.out.println("How many would you like to sell? (you have " + game.getSilkAmt() + ")");
                        amount = intInput();
                        tempPrice = silk*amount;

                        if (amount < game.getSilkAmt())
                        {
                            System.out.println("You don't have that many to sell");
                        }

                        else
                        {
                            game.subSilkAmt(amount);
                            game.addMoney(tempPrice);
                            System.out.println("Sold " + amount + " silk for a profit of: " + tempPrice);
                        }
                        break;

                    case 4: //diamond
                        System.out.println("How many would you like to sell? (you have " + game.getDiamondAmt() + ")");
                        amount = intInput();
                        tempPrice = diamond*amount;

                        if (amount < game.getDiamondAmt())
                        {
                            System.out.println("You don't have that many to sell");
                        }

                        else
                        {
                            game.subDiamondAmt(amount);
                            game.addMoney(tempPrice);
                            System.out.println("Sold " + amount + " diamond for a profit of: " + tempPrice);
                        }
                        break;

                    case 5:	//ivory
                        System.out.println("How many would you like to sell? (you have " + game.getIvoryAmt() + ")");
                        amount = intInput();
                        tempPrice = ivory*amount;

                        if (amount < game.getIvoryAmt())
                        {
                            System.out.println("You don't have that many to sell");
                        }

                        else
                        {
                            game.subIvoryAmt(amount);
                            game.addMoney(tempPrice);
                            System.out.println("Sold " + amount + " ivory for a profit of: " + tempPrice);
                        }
                        break;

                    case 6: //tea
                        System.out.println("How many would you like to sell? (you have " + game.getTeaAmt() + ")");
                        amount = intInput();
                        tempPrice = tea*amount;

                        if (amount < game.getTeaAmt())
                        {
                            System.out.println("You don't have that many to sell");
                        }

                        else
                        {
                            game.subTeaAmt(amount);
                            game.addMoney(tempPrice);
                            System.out.println("Sold " + amount + " gold for a profit of: " + tempPrice);
                        }
                        break;

                    default:
                        break;
                }
                break;

            case 3:
                break;
            default:
                break;

        }
    }

    //prints the game title.
    private static void printTitle()
    {
        System.out.println("\n");
        System.out.println("		  .oooooo..o  o8o  oooo  oooo             ooooooooo.                             .o8");
        System.out.println("		 d8P'    `Y8  `\"'  `888  `888             `888   `Y88.                          \"888");
        System.out.println(" 		 Y88bo.      oooo   888   888  oooo        888   .d88'  .ooooo.   .oooo.    .oooo888");
        System.out.println("		  `\"Y8888o.  `888   888   888 .8P'         888ooo88P'  d88' `88b `P  )88b  d88' `888");
        System.out.println("		      `\"Y88b  888   888   888888.          888`88b.    888   888  .oP\"888  888   888");
        System.out.println("		 oo     .d8P  888   888   888 `88b.        888  `88b.  888   888 d8(  888  888   888");
        System.out.println("		 8\"\"88888P'  o888o o888o o888o o888o      o888o  o888o `Y8bod8P' `Y888\"\"8o `Y8bod88P");
        System.out.println("\n");
    }

    //displays info for each city.
    private static void drawBoard(String city)
    {
        System.out.println("\n\n\n\n\n\n");
        System.out.println("------ " + city + " ------");
        System.out.println("Name: " + game.getName());
        System.out.println("Money: " + game.getMoney());
        System.out.println("Days: " + game.getDays());
    }

    //displays the names of the cities when travel is selected.
    private static void printCityNames()
    {
        System.out.println("<1> Constantinople     <2> Rome        <3>Bombay");
        System.out.println("<4> Alexandria         <5> Aleppo      <6> Xi'an");
    }

    //All integer input goes through here. It catches any InputMismatch exceptions.
    private static int intInput()
    {
        Scanner keyboard = new Scanner(System.in);
        int masterInt = 0;

        try
        {
            masterInt = keyboard.nextInt();
        }

        catch (InputMismatchException e)
        {
            System.out.println("Please make a valid entry");
        }
        return masterInt;
    }

    /*Generates a random number within the range give. Used for setting
      the price of items at each city */
    private static int randInt(int min, int max)
    {

        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    //displays the buy/sell/travel options
    private static void printOptions()
    {
        System.out.println("What would you like to do?");
        System.out.println("<1> Buy     <2> Sell     <3> Travel");
    }

    //displays the items that can be bought or sold.
    private static void printBuySell()
    {
        System.out.println("<1> Gold      <2> Silver     <3> Silk");
        System.out.println("<4> Diamond   <5> Ivory      <6> Tea");
    }

    //when the game is complete, this writes the persons name and ending money to a file
    private static void writeHighScore()
    {
        try(FileWriter fw = new FileWriter("HighScores.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(game.getMoney() + " : " + game.getName());

        }
        catch (IOException e)
        {
            System.out.println("Error writing to file");
        }
    }

    /* This method reads in all the high scores that are in the file. It then passes them
       to the sorting method and finally, displays them to the user in order of score. */
    private static void printHighScore()
    {

        Scanner inputStream = null;
        ArrayList<String> score = new ArrayList<>();

        try
        {
            inputStream = new Scanner(new FileInputStream("HighScores.txt"));
        }

        catch (FileNotFoundException e)
        {
            System.out.println("Cannot fine file \"HighScores.txt\"");
        }

        while (inputStream.hasNextLine())
        {
            score.add(inputStream.nextLine());
        }

        String[] scoreArr = new String[score.size()];
        scoreArr = score.toArray(scoreArr);
        scoreArr = sortScores(scoreArr);

        for (int i = 0; i < scoreArr.length; i++)
        {
            System.out.println(scoreArr[i]);
        }

    }

    //Bubble sort for high score file.
    private static String[] sortScores(String scores[])
    {

        String temp;

        for(int i = 0; i<scores.length - 1; i++)
        {
            for(int j = 0; j<scores.length - 1; j++)
            {
                if(scores[j].compareTo(scores[j+1]) > 0)
                {
                    temp = scores[j];
                    scores[j] = scores[j+1];
                    scores[j+1] = temp;
                }
            }
        }

        return scores;
    }

}