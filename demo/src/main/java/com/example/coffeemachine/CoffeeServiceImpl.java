package com.example.coffeemachine;

import com.example.coffeemachine.enums.CoffeeType;
import com.example.coffeemachine.enums.CupSize;
import com.example.coffeemachine.enums.MilkAmount;
import com.example.coffeemachine.enums.Prices;
import com.example.coffeemachine.models.Coffee;
import com.example.coffeemachine.models.Stock;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
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
        Inventory.waterAmount = 1000;
        return milkAmounts;
    }

    public Stock getStock()
    {
        return new Stock();
    }

    @Override
    public double calculatePrice(Coffee coffee)
    {
        double cupSize = coffee.cupSize.getSize();
        double milkAmount = (cupSize*coffee.milkAmount.getPercentage())/100;
        double waterAmount = cupSize - milkAmount;

        int coffeAmount = 0;

        if(coffee.cupSize == CupSize.SMALL)
            coffeAmount = 10;

        if(coffee.cupSize == CupSize.MEDIUM)
            coffeAmount = 12;

        if(coffee.cupSize == CupSize.LARGE)
            coffeAmount = 15;

        DecimalFormat df = new DecimalFormat("#.##");
        double price = waterAmount* Prices.WATER.getPrice();
        price += milkAmount*Prices.MILK.getPrice();
        price += coffeAmount*Prices.COFFEE.getPrice();
        price = Double.parseDouble(df.format(price));

        return price;
    }

    @Override
    public boolean prepareCoffee() {
        return false;
    }

    @Override
    public void UpdateStock() {

    }
}
