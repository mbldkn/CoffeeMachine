package com.example.coffeemachine;

import com.example.coffeemachine.enums.CoffeeType;
import com.example.coffeemachine.enums.CupSize;
import com.example.coffeemachine.enums.MilkAmount;
import com.example.coffeemachine.models.*;

import java.util.List;

public interface CoffeeService
{
    List<String> getCoffeeTypes();
    List<String> getCupSizes();
    List<MilkAmountResponse> getMilkAmount();
    Stock getStock();
    PrepareCoffeeResponse prepareCoffee(Coffee coffee);
    void refillStock();
}
