package RestaurantMenu.service;

import RestaurantMenu.model.Client;
import RestaurantMenu.model.Dish;
import RestaurantMenu.model.Menu;
import RestaurantMenu.model.Restriction;

import java.util.List;
import java.util.Set;

public class ClientService {
    protected Client client;

    /*public ClientService(int time, double money, Set<Restriction> restrictions) {
        this.client = new Client(time, money, restrictions);
    }*/

    public void createClient(int time, double money, Set<Restriction> restrictions) throws Exception {
        if (time<=0 && money<0) {
            throw new Exception("Incorrect input");
        }
        this.client = new Client(time, money, restrictions);
    }

    public boolean isAvailable(int time, double price) {
        return this.client.getMoney() > price && this.client.getTime() > time;
    }

    public void order(List<Dish> order) {
        client.setOrder(order);
    }

    public void bill(List<Dish> order, double fullPrice) {
        client.setOrder(order);
        client.setMoney(client.getMoney() - fullPrice);
    }

    public void setPersonalMenu(Menu personalMenu) throws Exception{
        if(personalMenu == null) {
            throw new Exception("Personal menu has not been generated");
        }
        client.setPersonalMenu(personalMenu);
    }

}
