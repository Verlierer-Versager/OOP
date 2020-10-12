package RestaurantMenu.model;

public abstract class Dish{
    protected double price;
    protected int time;
    protected Restriction restriction;

    public Dish(double price, int time, Restriction restriction) {
        this.price = price;
        this.time = time;
        this.restriction = restriction;
    }

    public Dish(double price, int time) {
        this(price, time, Restriction.NONE);
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
}
