package RestaurantMenu.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Dish> dishes;

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Menu(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public Menu() {
        this.dishes = new ArrayList<>();
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(var element: dishes) {
            stringBuilder.append(element.getId() + "\t" +element.getName() + "\t" + element.getPrice() + "\t" + element.getTime() +  "\n");
        }
        return "ID\tName\tPrice\tWaiting time\n" + stringBuilder.toString();
    }

}
