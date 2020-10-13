package RestaurantMenu.service;

import RestaurantMenu.model.Client;
import RestaurantMenu.model.Dish;
import RestaurantMenu.model.Restriction;

import java.util.List;
import java.util.Set;

public class ClientService {
    protected Client client;

    public ClientService(int time, double money, Set<Restriction> restrictions) {
        this.client = new Client(time, money, restrictions);
    }

    public boolean isAvailable(int time, double price) {
        return this.client.getMoney() > price && this.client.getTime() > time;
    }

    public void order(List<Dish> order, double fullPrice) {
        client.setOrder(order);
        client.setMoney(client.getMoney() - fullPrice);
    }

}
