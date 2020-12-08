package RestaurantMenu.model;

import java.util.*;

public class Discount {
    private Set<Set<Dish>> combinations = new LinkedHashSet<>();
    private int discount;

    public Discount(int discount) {
        this.discount = discount;
    }

    public Discount(Set<Set<Dish>> combinations, int discount) {
        this.combinations = combinations;
        this.discount = discount;
    }

    public Set<Set<Dish>> getCombinations() {
        return combinations;
    }

    public void setCombinations(Set<Set<Dish>> combinations) {
        this.combinations = combinations;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
