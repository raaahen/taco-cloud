package ru.raaahen.taco_cloud.web.controller;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import ru.raaahen.taco_cloud.data.entity.Ingredient;
import ru.raaahen.taco_cloud.data.entity.Taco;
import ru.raaahen.taco_cloud.data.entity.TacoOrder;
import ru.raaahen.taco_cloud.data.entity.Ingredient.Type;
import ru.raaahen.taco_cloud.data.repository.IngredientRepository;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController 
{
    private final IngredientRepository ingredientRepo;

    @Autowired
    public DesignTacoController(IngredientRepository ingredientRepo)
    {
        this.ingredientRepo = ingredientRepo;
    }

    @ModelAttribute
    public void addIngredientsToModel(Model model) 
    {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepo.findAll().forEach(ingredients::add);
        Type[] types = Ingredient.Type.values();
        for (Type type : types) 
        {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
    }

    @ModelAttribute(name = "tacoOrder")
    public TacoOrder order()
    {
        return new TacoOrder();
    }

    @ModelAttribute(name = "taco")
    public Taco taco()
    {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm()
    {
        return "design";
    }

    @PostMapping
    private String processDesign(@Valid @ModelAttribute("taco") Taco taco, Errors errors,
        @ModelAttribute("order") TacoOrder tacoOrder)
    {
        if (errors.hasErrors())
        {
            return "design";
        }
        tacoOrder.addTaco(taco);
        log.info("Proccessing taco {}", taco);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type)
    {
        return ingredients.stream()
            .filter(x -> x.getType().equals(type))
            .collect(Collectors.toList());
    }
}
