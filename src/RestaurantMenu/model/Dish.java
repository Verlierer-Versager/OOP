package RestaurantMenu.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Dish{
    protected String name;
    protected double price;
    protected int time;
    protected Category category;
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

    public Dish(String name, double price, int time, List<Ingredient> ingredients, Category category) {
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

    /*@Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        return result;
    }*/
}
