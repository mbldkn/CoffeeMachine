package com.example.coffeemachine;

import com.example.coffeemachine.enums.CoffeeType;
import com.example.coffeemachine.enums.CupSize;
import com.example.coffeemachine.enums.MilkAmount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
