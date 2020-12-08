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
        //var select = Optional.of(newOrder); //Хотелось через Optional, но не получилось
        for (var dish : newOrder) {
            for(var combo: combos) {
                if(combo.contains(dish)) {
                    Set<Dish> temp = new LinkedHashSet<>();
                    for(var comboDish: combo) {
                        if (order.contains(comboDish)) {
                            temp.add(comboDish);
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
            if(!order.isEmpty()) {
                withDiscount.addAll(order);
            }
            /*order = newOrder;
            /*if (discount.getCombinations().containsKey(dish)) {
                withDiscount.add(dish);
                withDiscount.add(discount.getCombinations().get(dish));
                continue;
            }
            if (discount.getCombinations().containsValue(dish)) {
                //withDiscount.add(discount.getCombinations().get(dish));
                var result = discount.getCombinations().entrySet()
                        .stream()
                        .filter(entry -> dish.equals(entry.getValue()))
                        .map(Map.Entry::getKey)
                        .findFirst().isPresent();
                    withDiscount.add(result.get());
                    withDiscount.add(dish);
                }
            }*/
        }
        return withDiscount;
    }
}
