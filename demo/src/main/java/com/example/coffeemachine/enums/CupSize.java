package com.example.coffeemachine.enums;

public enum CupSize
{
    SMALL(160, 10),
    MEDIUM(200, 12),
    LARGE(250, 15);

    private double size;
    private int coffeeAmount;

    CupSize(double size, int coffeeAmount)
    {
        this.size = size;
        this.coffeeAmount = coffeeAmount;
    }

    public double getSize()
    {
        return size;
    }

    public int getCoffeeAmount()
    {
        return coffeeAmount;
    }
}
