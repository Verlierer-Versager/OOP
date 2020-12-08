package RestaurantMenu.service;

import RestaurantMenu.model.*;

import javax.crypto.spec.PSource;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class ClientService {
    protected Client client;

    /*public ClientService(int time, double money, Set<Restriction> restrictions) {
        this.client = new Client(time, money, restrictions);
    }*/

    public void createClient(long id, int time, double money, EnumSet<Restriction> restrictions) throws Exception {
        if (time <= 0 && money < 0) {
            throw new IllegalArgumentException("Incorrect input");
        }
        this.client = new Client(id, time, money, restrictions);
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
