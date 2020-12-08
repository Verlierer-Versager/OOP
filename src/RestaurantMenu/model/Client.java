package RestaurantMenu.model;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class Client {
    private long id;
    private String name;
    private int time;
    private double money;
    private EnumSet<Restriction> restrictions;
    private Menu personalMenu;
    private Order order;

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

    public Client(long id, String name, int time, double money, EnumSet<Restriction> restrictions) {
        this.id = id;
        this.name = name;
        this.time = time;
        this.money = money;
        this.restrictions = restrictions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public EnumSet<Restriction> getRestrictions() {
        return restrictions;
    }

    public void setRestrictions(EnumSet<Restriction> restrictions) {
        this.restrictions = restrictions;
    }
}
