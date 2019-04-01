package com.example.demo.dao;

import com.example.demo.domain.Ingredient;

public interface IngredientRepository {
    Iterable<Ingredient> findAll();

    Ingredient findById(String id);

    Ingredient save(Ingredient ingredient);
}
