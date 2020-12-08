package RestaurantMenu.service;

import RestaurantMenu.model.*;

import javax.crypto.spec.PSource;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class ClientService {
    private List<Client> clients = new ArrayList<>();
    private long id = 0;


    public void createClient(String name, int time, double money, EnumSet<Restriction> restrictions) throws Exception {
        if (time <= 0 && money < 0 && name != null && name != "") {
            throw new IllegalArgumentException("Incorrect input");
        }
        clients.add(new Client(id, name,  time, money, restrictions));
        id++;
    }

    public boolean isAvailable(long id, int time, double price) {
        return clients.get((int) id).getMoney() > price && clients.get((int) id).getTime() > time;
    }

    public void order(Order order, long id) {
        clients.get((int) id).setOrder(order);
    }

    public void bill(Order order, double fullPrice, long id) {
        clients.get((int) id).setOrder(order);
        clients.get((int) id).setMoney(clients.get((int) id).getMoney() - fullPrice);
    }

    public void setPersonalMenu(Menu personalMenu, long id) throws Exception {
        if (personalMenu == null) {
            throw new IllegalArgumentException("Personal menu has not been generated");
        }
        clients.get((int) id).setPersonalMenu(personalMenu);
    }

    public Menu getPersonalMenu(long id) {
        return clients.get((int) id).getPersonalMenu();
    }

    public Client getClient(long id) {
        return clients.get((int) id);
    }

    public Client getLastClient() {
        return clients.get(clients.size() - 1);
    }
}
