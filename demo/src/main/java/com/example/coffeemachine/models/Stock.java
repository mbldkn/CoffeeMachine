package com.example.coffeemachine.models;

import com.example.coffeemachine.Inventory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stock
{
    public double milkAmount = Inventory.milkAmount;
    public double waterAmount = Inventory.waterAmount;
    public int cupCount = Inventory.cupCount;
    public double standartCoffeeAmount = Inventory.standartCoffeeAmount;
    public double hazelnutCoffeeAmount = Inventory.hazelnutCoffeeAmount;
    public double guatemalaCoffeeAmount = Inventory.guatemalaCoffeeAmount;
    public double costaRicaCoffeeAmount = Inventory.costaRicaCoffeeAmount;
    public double colombiaCoffeeAmount = Inventory.colombiaCoffeeAmount;
    public double antiguaCoffeeAmount = Inventory.antiguaCoffeeAmount;
    public double elSalvadorCoffeeAmount = Inventory.elSalvadorCoffeeAmount;
}
