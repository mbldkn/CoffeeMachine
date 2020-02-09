package com.example.coffeemachine.enums;

public enum CupSize
{
    SMALL(160),
    MEDIUM(200),
    LARGE(250);

    private double size;

    CupSize(double size)
    {
        this.size = size;
    }

    public double getSize()
    {
        return size;
    }
}
