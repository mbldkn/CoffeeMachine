package com.example.coffeemachine;

import com.example.coffeemachine.enums.CoffeeType;
import com.example.coffeemachine.enums.CupSize;
import com.example.coffeemachine.enums.MilkAmount;
import com.example.coffeemachine.models.Coffee;
import com.example.coffeemachine.models.PrepareCoffeeResponse;
import com.example.coffeemachine.models.Stock;

import java.util.List;

public interface CoffeeService
{
    List<CoffeeType> getCoffeeTypes();
    List<CupSize> getCupSizes();
    List<MilkAmount> getMilkAmount();
    Stock getStock();
    PrepareCoffeeResponse prepareCoffee(Coffee coffee);
    void refillStock();
}
