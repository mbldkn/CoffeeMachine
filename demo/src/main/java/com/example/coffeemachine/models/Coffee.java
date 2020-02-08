package com.example.coffeemachine.models;

import com.example.coffeemachine.enums.CoffeeType;
import com.example.coffeemachine.enums.CupSize;
import com.example.coffeemachine.enums.MilkAmount;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coffee
{
    public CupSize cupSize;
    public MilkAmount milkAmount;
    public CoffeeType coffeeType;
}
