package RestaurantMenu.model;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class Dish{
    private long id;
    private String name;
    private double price;
    private int time;
    private Category category;
    private EnumSet<Restriction> restrictions;
    private List<Ingredient> ingredients  = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Dish(String name, double price, int time, List<Ingredient> ingredients, Category category, long id) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.time = time;
        this.ingredients = ingredients;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public EnumSet<Restriction> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(EnumSet<Restriction> restrictions) {
        this.restrictions = restrictions;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dish dish = (Dish) o;

        if (name != null ? !name.equals(dish.name) : dish.name != null) return false;
        if(Math.abs(price-dish.getPrice())>1e-6) return false;
        if(time != dish.getTime()) return false;
        if(!restrictions.equals(dish.getRestrictions())) return false;
        if(!ingredients.equals(dish.getIngredients())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + ((Integer.valueOf(time).hashCode())); //(time ^ (time >>> 32))
        result = 31 * result + (Double.valueOf(price).hashCode());
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (restrictions != null ? restrictions.hashCode() : 0);
        result = 31 * result + (ingredients != null ? ingredients.hashCode() : 0);
        return result;
    }
}
