package ru.raaahen.taco_cloud.data;

import java.util.List;

import lombok.Data;

@Data
public class Taco 
{
    private String name;
    private List<Ingredient> ingredients;
}
