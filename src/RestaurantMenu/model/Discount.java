package RestaurantMenu.model;

import java.util.HashMap;
import java.util.Map;

public class Discount {
    private Map<Dish, Dish> combinations = new HashMap<>();
    private int discount;

    public Discount(int discount) {
        this.discount = discount;
    }

    public Discount(Map<Dish, Dish> combinations, int discount) {
        this.combinations = combinations;
        this.discount = discount;
    }

    public Map<Dish, Dish> getCombinations() {
        return combinations;
    }

    public void setCombinations(Map<Dish, Dish> combinations) {
        this.combinations = combinations;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
}
