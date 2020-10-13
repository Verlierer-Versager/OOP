package RestaurantMenu.model;

import java.util.List;
import java.util.Set;

public class Client {
    protected int time;
    protected double money;
    protected Set<Restriction> restrictions;
    protected Menu personalMenu = null;
    protected Order order;

    public Menu getPersonalMenu() {
        return personalMenu;
    }

    public void setPersonalMenu(Menu personalMenu) {
        this.personalMenu = personalMenu;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Client(int time, double money, Set<Restriction> restrictions) {
        this.time = time;
        this.money = money;
        this.restrictions = restrictions;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Set<Restriction> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(Set<Restriction> restrictions) {
        this.restrictions = restrictions;
    }
}
