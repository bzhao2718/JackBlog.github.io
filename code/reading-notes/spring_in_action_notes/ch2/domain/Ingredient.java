package com.springInAction.tacoCloud.domain.tacos;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

/**
 * @author BoZhao
 */
@Data
@RequiredArgsConstructor
@NoArgsConstructor(force = true)
public class Ingredient
{
    private final String id;
    private final String name;
    private final IngredientType type;


    public static enum IngredientType {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
