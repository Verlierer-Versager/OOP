package RestaurantMenu.service;

import RestaurantMenu.model.Dish;
import RestaurantMenu.model.Order;

import java.util.List;

public class OrderService {
    private Order order;

    public Order createOrder(int fullTime, double fullPrice, List<Dish> order) {
        this.order = new Order(fullTime, fullPrice, order);
        return this.order;
    }
}
