package com.example.coffeemachine;

import com.example.coffeemachine.enums.CoffeeType;
import com.example.coffeemachine.enums.CupSize;
import com.example.coffeemachine.enums.MilkAmount;
import com.example.coffeemachine.enums.Prices;
import com.example.coffeemachine.models.Coffee;
import com.example.coffeemachine.models.GenericResponse;
import com.example.coffeemachine.models.PrepareCoffeeResponse;
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

    public PrepareCoffeeResponse prepareCoffee(Coffee coffee)
    {
        PrepareCoffeeResponse prepareCoffeeResponse = new PrepareCoffeeResponse();
        GenericResponse genericResponse = isAvailable(coffee);
        prepareCoffeeResponse.message = genericResponse.message;
        prepareCoffeeResponse.status = genericResponse.status;

        if(prepareCoffeeResponse.status == 1)
            return prepareCoffeeResponse;

        prepareCoffeeResponse.price = calculatePrice(coffee);
        prepareCoffeeResponse.coffee = coffee;
        updateStock(coffee);

        return prepareCoffeeResponse;
    }

    public void updateStock(Coffee coffee)
    {
        double cupSize = coffee.cupSize.getSize();
        double milkAmount = (cupSize*coffee.milkAmount.getPercentage())/100;
        double waterAmount = cupSize - milkAmount;
        String coffeeName = coffee.coffeeType.name().toLowerCase() + "CoffeeAmount";

        Inventory.setCoffeeAmount(coffeeName, coffee.cupSize.getCoffeeAmount());
        Inventory.waterAmount -= waterAmount;
        Inventory.milkAmount -= milkAmount;
        Inventory.cupCount -= 1;
    }

    public double calculatePrice(Coffee coffee)
    {
        //TODO isAvailable metodu ile kod tekrarı var. Burası sonra çözülecek.
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

    public GenericResponse isAvailable(Coffee coffee)
    {
        GenericResponse response =  new GenericResponse();
        response.status = 1;

        String coffeeName = coffee.coffeeType.name().toLowerCase() + "CoffeeAmount";
        double coffeeAmount = Inventory.getCoffeeAmount(coffeeName);
        double milkAmount = (coffee.cupSize.getSize()*coffee.milkAmount.getPercentage())/100;
        double waterAmount = coffee.cupSize.getSize() - milkAmount;

        //TODO if kontrolleri yerine başka bir çözüm aranmalı. Hoş bir yapı değil.
        if(Inventory.cupCount == 0)
        {
            response.message = "Yeterince bardağınız bulunmamaktadır";
            return response;
        }
        if(coffee.cupSize.getCoffeeAmount() > coffeeAmount)
        {
            response.message = "Yeterince " + coffee.coffeeType.name().toLowerCase() + " kahveniz bulunmamaktadır";
            return response;
        }
        if(milkAmount > Inventory.milkAmount)
        {
            response.message = "Makinede yeterince süt bulunmamaktadır.";
            return response;
        }
        if(waterAmount > Inventory.waterAmount)
        {
            response.message = "Makinede yeterince su bulunmamaktadır";
            return response;
        }

        response.status = 0;
        response.message = "Kahveniz hazır";
        return response;
    }
}
