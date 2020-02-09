package com.example.coffeemachine.models;

import com.example.coffeemachine.enums.MilkAmount;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MilkAmountResponse
{
    public String name;
    public MilkAmount value;
}
