package edu.miracosta.cs113.hw5.part2;

import java.util.Random;

/** Used for randomly generating a company name, a widget name, a price, and an integer between
 *  1 and 10. */
public class RandomGenerator_P2
{
    String[] companyNames = new String[10];
    String[] widgetNames = new String[10];
    double[] price = new double[4];

    Random rand = new Random();

    public RandomGenerator_P2()
    {
        companyNames[0] = "Triple Diesel Petroleum";
        companyNames[1] = "Skywalker Productions";
        companyNames[2] = "Silver Haise Ltd.";
        companyNames[3] = "Bruce Banner Inc";
        companyNames[4] = "Afgooey Systems";
        companyNames[5] = "Ultra MK Machining";
        companyNames[6] = "Headband Designs";
        companyNames[7] = "Blue Dream Brewing Co.";
        companyNames[8] = "OGK Materials Inc";
        companyNames[9] = "The Jack Herer Company";

        widgetNames[0] = "Horton";
        widgetNames[1] = "Lorax";
        widgetNames[2] = "Thidwick";
        widgetNames[3] = "Sneetches";
        widgetNames[4] = "Yertle";
        widgetNames[5] = "Looie Katz";
        widgetNames[6] = "Hunches";
        widgetNames[7] = "Yooks";
        widgetNames[8] = "Zooks";
        widgetNames[9] = "Wocket";

        price[0] = 19.99;
        price[1] = 34.99;
        price[2] = 49.99;
        price[3] = 79.99;
    }

    public String getCompanyName()
    {
        return companyNames[rand.nextInt(10)];
    }

    public String getWidgetName()
    {
        return widgetNames[rand.nextInt(10)];
    }

    public int getNumber()
    {
        return rand.nextInt(9) + 1;
    }

    public double getPrice()
    {
        return price[rand.nextInt(4)];
    }
}
