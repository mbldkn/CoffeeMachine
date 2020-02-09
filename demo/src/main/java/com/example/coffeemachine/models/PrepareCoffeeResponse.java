package com.example.coffeemachine.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PrepareCoffeeResponse extends GenericResponse
{
    public Coffee coffee;
    public double price;
}
