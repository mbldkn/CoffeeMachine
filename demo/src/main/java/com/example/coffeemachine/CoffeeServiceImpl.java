package com.example.coffeemachine;

import com.example.coffeemachine.enums.CoffeeType;
import com.example.coffeemachine.enums.CupSize;
import com.example.coffeemachine.enums.MilkAmount;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService
{
    public List<CoffeeType> getCoffeeTypes()
    {
        List<CoffeeType> coffeeTypes = new ArrayList<>();
        coffeeTypes.add(CoffeeType.STANDART);
        coffeeTypes.add(CoffeeType.ANTIGUA);
        coffeeTypes.add(CoffeeType.COLOMBIA);
        coffeeTypes.add(CoffeeType.COSTARICA);
        coffeeTypes.add(CoffeeType.ELSALVADOR);
        coffeeTypes.add(CoffeeType.HAZELNUT);
        coffeeTypes.add(CoffeeType.GUATEMALA);
        return coffeeTypes;
    }

    public List<CupSize> getCupSizes()
    {
        List<CupSize> cupSizes = new ArrayList<>();
        cupSizes.add(CupSize.SMALL);
        cupSizes.add(CupSize.MEDIUM);
        cupSizes.add(CupSize.LARGE);
        return cupSizes;
    }

    public List<MilkAmount> getMilkAmount()
    {
        List<MilkAmount> milkAmounts = new ArrayList<>();
        milkAmounts.add(MilkAmount.NONE);
        milkAmounts.add(MilkAmount.ONESHOT);
        milkAmounts.add(MilkAmount.TWOSHOTS);
        milkAmounts.add(MilkAmount.THREESHOTS);
        return milkAmounts;
    }
}
