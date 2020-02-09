package com.example.coffeemachine.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockResponse
{
    public GenericResponse genericResponse;
    public Stock stock;
}
