package com.example.coffeemachine.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetResponse<T>
{
    public List<T> list;
}
