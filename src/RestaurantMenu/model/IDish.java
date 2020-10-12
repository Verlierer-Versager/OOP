package RestaurantMenu.model;

public interface IDish {
    public String getCategory();

    public int getTime();

    public double getPrice();

    public void setPrice(double price);

    public void setCategory(String category);

    public void setTime(int time);
}
