package RestaurantMenu.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int fullTime = 0;
    private double fullPrice = 0.0;
    private List<Dish> order = new ArrayList<>();

    public Order(int fullTime, double fullPrice, List<Dish> order) {
        this.fullTime = fullTime;
        this.fullPrice = fullPrice;
        this.order = order;
    }

    public int getFullTime() {
        return fullTime;
    }

    public void setFullTime(int fullTime) {
        this.fullTime = fullTime;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }

    public List<Dish> getOrder() {
        return order;
    }

    public void setOrder(List<Dish> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(var element: order) {
            stringBuilder.append(element.getName() + "\n");
        }
        return new String("Dishes: \n" + stringBuilder.toString()
                + "Waiting time: " + fullTime + "\n"
                + "Order price: " + fullPrice);
    }
}
