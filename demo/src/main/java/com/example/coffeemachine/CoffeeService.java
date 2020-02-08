package com.example.coffeemachine;

import com.example.coffeemachine.enums.CoffeeType;
import com.example.coffeemachine.enums.CupSize;
import com.example.coffeemachine.enums.MilkAmount;

import java.util.List;

public interface CoffeeService
{
    List<CoffeeType> getCoffeeTypes();
    List<CupSize> getCupSizes();
    List<MilkAmount> getMilkAmount();
}
