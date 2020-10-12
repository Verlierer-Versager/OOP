package RestaurantMenu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Dish{
    protected String name;
    protected double price;
    protected int time;
    protected Set<Restriction> restrictions;
    protected List<Ingredient> ingredients  = new ArrayList<>();

    /*public Dish(double price, int time, Restriction restriction) {
        this.price = price;
        this.time = time;
        this.restriction = restriction;
    }*/

    /*public Dish(String name, double price, int time) {
        this.name = name;
        this.price = price;
        this.time = time;;
    }*/

    public Dish(String name, double price, int time, List<Ingredient> ingredients) {
        this.name = name;
        this.price = price;
        this.time = time;
        this.ingredients = ingredients;
    }

    public int getTime() {
        return time;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Set<Restriction> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Set<Restriction> restrictions) {
        this.restrictions = restrictions;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
}
