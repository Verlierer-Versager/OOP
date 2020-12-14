package RestaurantMenu.service;

import RestaurantMenu.model.Discount;
import RestaurantMenu.model.Dish;

import java.util.*;

public class DiscountService {
    private Discount discount = new Discount(15);

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setCombinations(Set<Set<Dish>> combinations) {
        discount.setCombinations(combinations);
    }

    public List<Dish> countDiscount(List<Dish> order, DishService dishService) {
        var newOrder = List.copyOf(order);
        List<Dish> withDiscount = new ArrayList<>();
        var combos =  discount.getCombinations();
        for (var dish : newOrder) {  //проходка по каждому блюду в заказе
            for(var combo: combos) { //для каждого блюда проходка по всем комбо
                if(combo.contains(dish)) { //если это блюдо принадлежит какому-то комбо
                    checkDishesForCombo(combo, order, withDiscount, dishService);
                }
            }
        }
        if(!order.isEmpty()) {
            withDiscount.addAll(order);
        }
        return withDiscount;
    }

    private void checkDishesForCombo(Set<Dish> combo, List<Dish> order, List<Dish> withDiscount, DishService dishService) {
        Set<Dish> temp = new LinkedHashSet<>();
        for(var comboDish: combo) { //для каждого блюда в этом комбо
            if (order.contains(comboDish)) { // если заказ содержит другие блюда из комбо
                temp.add(comboDish); //то добавляем его в множество
            }
        }
        if(temp.equals(combo)) {
            for(var comboDish: combo) {
                int index = order.indexOf(comboDish);
                order.remove(index);
                double discountPrice = comboDish.getPrice() * (100 - discount.getDiscount()) / 100;
                Dish discountDish = dishService.copy(comboDish);
                discountDish.setPrice(discountPrice);
                withDiscount.add(discountDish);
            }
        }
    }
}
