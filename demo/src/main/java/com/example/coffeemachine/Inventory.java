package com.example.coffeemachine;

public class Inventory
{
    public static double waterAmount = 2000; // ml
    public static double milkAmount = 1000; // ml
    public static int cupCount = 200; // Cup Quantity
    public static double standartCoffeeAmount = 500; // gr
    public static double hazelnutCoffeeAmount = 500; // gr
    public static double guatemalaCoffeeAmount = 500; // gr
    public static double costaRicaCoffeeAmount = 500; // gr
    public static double colombiaCoffeeAmount = 500; // gr
    public static double antiguaCoffeeAmount = 500; // gr
    public static double elSalvadorCoffeeAmount = 500; // gr

    public static double getCoffeeAmount(String name)
    {
        // TODO Buraya başka bir çözüm lazım. Araştırılacak.
        if(name.equals("standartCoffeeAmount"))
            return standartCoffeeAmount;
        if(name.equals("hazelnutCoffeeAmount"))
            return hazelnutCoffeeAmount;
        if(name.equals("guatemalaCoffeeAmount"))
            return guatemalaCoffeeAmount;
        if(name.equals("costaRicaCoffeeAmount"))
            return costaRicaCoffeeAmount;
        if(name.equals("colombiaCoffeeAmount"))
            return colombiaCoffeeAmount;
        if(name.equals("antiguaCoffeeAmount"))
            return antiguaCoffeeAmount;
        if(name.equals("elSalvadorCoffeeAmount"))
            return elSalvadorCoffeeAmount;
        return 0;
    }

    public static void setCoffeeAmount(String name, double amount)
    {
        // TODO Buraya başka bir çözüm lazım. Araştırılacak.
        if(name.equals("standartCoffeeAmount"))
            standartCoffeeAmount -= amount;
        if(name.equals("hazelnutCoffeeAmount"))
           hazelnutCoffeeAmount -= amount;
        if(name.equals("guatemalaCoffeeAmount"))
            guatemalaCoffeeAmount -= amount;
        if(name.equals("costaRicaCoffeeAmount"))
            costaRicaCoffeeAmount -= amount;
        if(name.equals("colombiaCoffeeAmount"))
            colombiaCoffeeAmount -= amount;
        if(name.equals("antiguaCoffeeAmount"))
            antiguaCoffeeAmount -= amount;
        if(name.equals("elSalvadorCoffeeAmount"))
            elSalvadorCoffeeAmount -= amount;
    }
}
