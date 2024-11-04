package ru.raaahen.taco_cloud.data.repository;

import org.springframework.data.repository.CrudRepository;
import ru.raaahen.taco_cloud.data.entity.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, String>
{
}