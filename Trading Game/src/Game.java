import java.util.Scanner;

class Game
{
    /***** VARIABLES ******/
    private int money;
    private int days;
    private String name;

    private int goldAmt;
    private int silverAmt;
    private int silkAmt;
    private int diamondAmt;
    private int ivoryAmt;
    private int teaAmt;

    //DEFAULT CONSTRUCTOR
    Game()
    {
        money = 200;
        days = 1;

        System.out.print("Please enter your name: ");
        Scanner keyboard = new Scanner(System.in);
        name = keyboard.nextLine();
    }


    //METHODS
    int getMoney()
    {
        return money;
    }

    void addMoney(int add)
    {
        money += add;
    }
    void subMoney(int sub)
    {
        money -= sub;
    }

    String getName()
    {
        return name;
    }

    int getDays()
    {
        return days;
    }

    void addDay()
    {
        days++;
    }

    //THE METHODS BELOW HERE ALL RETURN AN ITEM, ADD ITEMS, OR SUBTRACTS ITEMS.
    int getGoldAmt()
    {
        return goldAmt;
    }

    void addGoldAmt(int gold)
    {
        goldAmt += gold;
    }

    void subGoldAmt(int gold)
    {
        goldAmt -= gold;
    }

    int getSilkAmt()
    {
        return silkAmt;
    }

    void addSilkAmt(int silk)
    {
        silkAmt += silk;
    }

    void subSilkAmt(int silk)
    {
        silkAmt -= silk;
    }

    int getDiamondAmt()
    {
        return diamondAmt;
    }

    void addDiamondAmt(int diamond)
    {
        diamondAmt += diamond;
    }

    void subDiamondAmt(int diamond)
    {
        diamondAmt -= diamond;
    }

    int getIvoryAmt()
    {
        return ivoryAmt;
    }

    void addIvoryAmt(int ivory)
    {
        ivoryAmt += ivory;
    }

    void subIvoryAmt(int ivory)
    {
        ivoryAmt -= ivory;
    }

    int getTeaAmt()
    {
        return teaAmt;
    }

    void addTeaAmt(int tea)
    {
        teaAmt += tea;
    }

    void subTeaAmt(int tea)
    {
        teaAmt -= tea;
    }

    int getSilverAmt()
    {
        return silverAmt;
    }

    void addSilverAmt(int silver)
    {
        silverAmt += silver;
    }

    void subSilverAmt(int silver)
    {
        silverAmt -= silver;
    }
}
