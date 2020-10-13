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
            stringBuilder.append(element.getName() + element.getPrice() + element.getTime() +  "\n");
        }

        return new String("Name                         Price        Waiting time\n" + stringBuilder.toString());
    }

}
