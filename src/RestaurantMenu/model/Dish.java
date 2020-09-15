package RestaurantMenu.model;

abstract class Dish{
    protected double price;
    protected int time;
    protected String category;

    public Dish(double price, int time, String category) {
        this.price = price;
        this.time = time;
        this.category = category;
    }

    public String getCategory() {
        return category;
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

    public void setCategory(String category) {
        this.category = category;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
