package RestaurantMenu.service;

import RestaurantMenu.model.Discount;
import RestaurantMenu.model.Dish;

import java.util.*;

public class DiscountService {
    private Discount discount = new Discount(15);

    public Set<Dish> countDiscount(List<Dish> order) {
        Set<Dish> withDiscount = new LinkedHashSet<>();
        for (var dish : order) {
            if (discount.getCombinations().containsKey(dish)) {
                withDiscount.add(dish);
                withDiscount.add(discount.getCombinations().get(dish));
                continue;
            }
            if (discount.getCombinations().containsValue(dish)) {
                withDiscount.add(dish);
                //withDiscount.add(discount.getCombinations().get(dish));
                var result = discount.getCombinations().entrySet()
                        .stream()
                        .filter(entry -> dish.equals(entry.getValue()))
                        .map(Map.Entry::getKey)
                        .findFirst();
                withDiscount.add(result.get());
            }
        }
        return withDiscount;
    }
}
