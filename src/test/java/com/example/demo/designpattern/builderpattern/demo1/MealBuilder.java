package com.example.demo.designpattern.builderpattern.demo1;

/**
 * @package: com.example.demo.designpattern.builderpattern.demo1
 * @author:
 * @email:
 * @createDate: 2019-06-10 18:40
 * @description:
 */
public class MealBuilder {
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
