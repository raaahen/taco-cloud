package ru.raaahen.taco_cloud.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AccessLevel;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Ingredient
{
    @Id
    private String id;
    private String name;
    private Type type;

    public enum Type 
    {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
