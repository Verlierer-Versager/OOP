package RestaurantMenu.service;

import RestaurantMenu.model.*;

import javax.crypto.spec.PSource;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class ClientService {
    private Client client;
    private long id = 0;

    /*public ClientService(int time, double money, Set<Restriction> restrictions) {
        this.client = new Client(time, money, restrictions);
    }*/

    public void createClient(String name, int time, double money, EnumSet<Restriction> restrictions) throws Exception {
        if (time <= 0 && money < 0 && name != null && name != "") {
            throw new IllegalArgumentException("Incorrect input");
        }
        this.client = new Client(id, name,  time, money, restrictions);
        id++;
    }

    public boolean isAvailable(int time, double price) {
        return this.client.getMoney() > price && this.client.getTime() > time;
    }

    public void order(Order order) {
        client.setOrder(order);
    }

    public void bill(Order order, double fullPrice) {
        client.setOrder(order);
        client.setMoney(client.getMoney() - fullPrice);
    }

    public void setPersonalMenu(Menu personalMenu) throws Exception {
        if (personalMenu == null) {
            throw new IllegalArgumentException("Personal menu has not been generated");
        }
        client.setPersonalMenu(personalMenu);
    }

    public Menu getPersonalMenu() {
        return client.getPersonalMenu();
    }

    public Client getClient() {
        return client;
    }
}
