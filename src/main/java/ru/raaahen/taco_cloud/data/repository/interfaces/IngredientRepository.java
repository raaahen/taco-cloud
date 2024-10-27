package ru.raaahen.taco_cloud.data.repository.interfaces;

import java.util.Optional;

import ru.raaahen.taco_cloud.data.entity.Ingredient;

public interface IngredientRepository 
{
    Iterable<Ingredient> findAll();
    Optional<Ingredient> findById(String id);
    Ingredient save(Ingredient ingredient);
}
