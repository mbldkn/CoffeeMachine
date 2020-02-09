package com.example.coffeemachine.models;

import com.example.coffeemachine.Inventory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stock
{
    public int milkAmount = Inventory.milkAmount;
    public int waterAmount = Inventory.waterAmount;
    public int cupCount = Inventory.cupCount;
    public int standartCoffeeAmount = Inventory.standartCoffeeAmount;
    public int hazelnutCoffeeAmount = Inventory.hazelnutCoffeeAmount;
    public int guatemalaCoffeeAmount = Inventory.guatemalaCoffeeAmount;
    public int costaRicaCoffeeAmount = Inventory.costaRicaCoffeeAmount;
    public int colombiaCoffeeAmount = Inventory.colombiaCoffeeAmount;
    public int antiguaCoffeeAmount = Inventory.antiguaCoffeeAmount;
    public int elSalvadorCoffeeAmount = Inventory.elSalvadorCoffeeAmount;
}
