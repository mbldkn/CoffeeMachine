package com.example.coffeemachine;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CoffeeMachineController
{
    @GetMapping("/coffee-types")
    public String CoffeeTypes()
    {
        return "Filter";
    }
}
