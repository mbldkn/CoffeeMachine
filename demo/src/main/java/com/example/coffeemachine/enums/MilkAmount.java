package com.example.coffeemachine.enums;

public enum MilkAmount
{
    NONE(0),
    ONESHOT(20),
    TWOSHOTS(30),
    THREESHOTS(40);

    private int percent;

    MilkAmount(int percent)
    {
        this.percent = percent;
    }

    public int getPercentage()
    {
        return percent;
    }
}
