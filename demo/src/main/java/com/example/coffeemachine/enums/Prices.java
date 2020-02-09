package com.example.coffeemachine.enums;

public enum  Prices
{
    COFFEE(0.80),
    WATER(0.001),
    MILK(0.05);

    private double price;

    Prices(double price)
    {
        this.price = price;
    }

    public double getPrice()
    {
        return price;
    }
}
