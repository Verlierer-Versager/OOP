package RestaurantMenu.model.categories;

import RestaurantMenu.model.Dish;
import RestaurantMenu.model.Restriction;

public class Salad extends Dish {
    public Salad(double price, int time, Restriction restriction) {
        super(price, time, restriction);
    }
}
