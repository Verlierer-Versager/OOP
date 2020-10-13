package RestaurantMenu.service;

import RestaurantMenu.model.Category;
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
        restrictions.remove(Restriction.NONE);
        dish.setRestrictions(restrictions);
    }

    public Dish createDish(String name, double price, int time, List<Ingredient> ingredients, Category category, long id) {
        return new Dish(name, price, time, ingredients, category, id ); //добавить в меню
    }

    public boolean isDishCorrect(Set<Restriction> restrictions, Dish dish) {
        var dishRestriction = dish.getRestrictions();
        for (var restriction: restrictions) {
            if(dishRestriction.contains(restriction)) return false;
        }
        return true;
    }
    //public void removeDish()

}
