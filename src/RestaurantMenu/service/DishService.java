package RestaurantMenu.service;

import RestaurantMenu.model.Category;
import RestaurantMenu.model.Dish;
import RestaurantMenu.model.Ingredient;
import RestaurantMenu.model.Restriction;

import java.awt.*;
import java.util.*;
import java.util.List;

public class DishService {

    public void setRestriction(Dish dish) {
        var ingredients = dish.getIngredients();
        EnumSet<Restriction> restrictions = EnumSet.noneOf(Restriction.class);
        for ( var ingredient: ingredients ) {
            restrictions.add(ingredient.getRestriction());

            if(restrictions.size() == Restriction.values().length ) break; //лишняя оптимизация
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

    public Dish copy(Dish dish) {
        return new Dish(dish.getName(), dish.getPrice(), dish.getTime(), dish.getIngredients(), dish.getCategory(), dish.getId());
    }
    //public void removeDish()

}
