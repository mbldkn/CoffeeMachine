package com.example.coffeemachine;

import com.example.coffeemachine.enums.CoffeeType;
import com.example.coffeemachine.enums.CupSize;
import com.example.coffeemachine.enums.MilkAmount;
import com.example.coffeemachine.models.Coffee;
import com.example.coffeemachine.models.PrepareCoffeeResponse;
import com.example.coffeemachine.models.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CoffeeMachineController
{

    @Autowired
    CoffeeService coffeeService;

    @GetMapping("/coffee-types")
    public List<CoffeeType> CoffeeTypes()
    {
        return coffeeService.getCoffeeTypes();
    }

    @GetMapping("/cup-sizes")
    public List<CupSize> CupSizes()
    {
        return coffeeService.getCupSizes();
    }

    @GetMapping("/milk-amount")
    public List<MilkAmount> MilkAmount()
    {
        return coffeeService.getMilkAmount();
    }

    @GetMapping("/stock")
    public Stock Stock()
    {
        return coffeeService.getStock();
    }

    @PostMapping("/prepare-coffee")
    public PrepareCoffeeResponse PrepareCoffee(@RequestBody Coffee coffee)
    {
        return coffeeService.prepareCoffee(coffee);
    }

    //Burası Post çünkü ileride database update metodları eklenecek.
    @PostMapping("/refill-stock")
    public void RefillStock()
    {
        coffeeService.refillStock();
    }
}
