package RestaurantMenu.service;

import RestaurantMenu.model.Dish;
import RestaurantMenu.model.Ingredient;
import RestaurantMenu.model.Restriction;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DishService {

    public void setRestriction(Dish dish) {
        var ingredients = dish.getIngredients();
        Set<Restriction> restrictions = new LinkedHashSet<>();
        for ( var ingredient: ingredients ) {
            restrictions.add(ingredient.getRestriction());

            if(restrictions.size() == Restriction.values().length ) break;
        }
        dish.setRestrictions(restrictions);
        //if(restrictions.contains(Restriction.NOT_VEGAN)) restrictions.remove(Restriction.VEGAN);
    }

    public Dish createDish(String name, double price, int time, List<Ingredient> ingredients) {
        return new Dish(name, price, time, ingredients); //добавить в меню
    }

    public void removeDish()

}
