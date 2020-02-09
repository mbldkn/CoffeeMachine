package com.example.coffeemachine;

import com.example.coffeemachine.enums.CoffeeType;
import com.example.coffeemachine.enums.CupSize;
import com.example.coffeemachine.enums.MilkAmount;
import com.example.coffeemachine.enums.Prices;
import com.example.coffeemachine.models.*;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService
{
    public List<String> getCoffeeTypes()
    {
        List<String> coffeeTypes = new ArrayList<>();
        coffeeTypes.add(CoffeeType.STANDART.name());
        coffeeTypes.add(CoffeeType.ANTIGUA.name());
        coffeeTypes.add(CoffeeType.COLOMBIA.name());
        coffeeTypes.add(CoffeeType.COSTARICA.name());
        coffeeTypes.add(CoffeeType.ELSALVADOR.name());
        coffeeTypes.add(CoffeeType.HAZELNUT.name());
        coffeeTypes.add(CoffeeType.GUATEMALA.name());
        return coffeeTypes;
    }

    public List<String> getCupSizes()
    {
        List<String> cupSizes = new ArrayList<>();
        cupSizes.add(CupSize.SMALL.name());
        cupSizes.add(CupSize.MEDIUM.name());
        cupSizes.add(CupSize.LARGE.name());
        return cupSizes;
    }

    public List<MilkAmountResponse> getMilkAmount()
    {
        List<MilkAmountResponse> milkAmountResponses = new ArrayList<>();
        MilkAmountResponse response = new MilkAmountResponse();
        response.name = "Sütsüz";
        response.value = MilkAmount.NONE;
        milkAmountResponses.add(response);

        response.name = "Az Sütlü";
        response.value = MilkAmount.ONESHOT;
        milkAmountResponses.add(response);

        response.name = "Orta";
        response.value = MilkAmount.TWOSHOTS;
        milkAmountResponses.add(response);

        response.name = "Bol Sütlü";
        response.value = MilkAmount.THREESHOTS;
        milkAmountResponses.add(response);

        Inventory.waterAmount = 1000;

        return milkAmountResponses;
    }

    public Stock getStock()
    {
        Stock stock = new Stock();
        return stock;
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

    //TODO Database kullanmaya başlayınca refill işlemi farklı şekilde yapılacak. Şimdilik böyle saçma bir şey maalesef.
    public void refillStock()
    {
        Inventory.waterAmount = 2000;
        Inventory.milkAmount = 1000;
        Inventory.cupCount = 200;
        Inventory.standartCoffeeAmount = 500;
        Inventory.hazelnutCoffeeAmount = 500;
        Inventory.guatemalaCoffeeAmount = 500;
        Inventory.costaRicaCoffeeAmount = 500;
        Inventory.colombiaCoffeeAmount = 500;
        Inventory.antiguaCoffeeAmount = 500;
        Inventory.elSalvadorCoffeeAmount = 500;
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
