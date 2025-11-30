package ecommerce.repo;

import ecommerce.model.*;
import java.util.*;

public class OrderRepo {

    // FIELD
    private List<Order> repo;


    // CONSTRUCTOR
    public OrderRepo() {
        this.repo = new ArrayList<>();
    }

    // ADD an order
    public void add(Order order) {
        if (order != null) {
            repo.add(order);
        }
    }

    // REMOVE an order
    public boolean remove(Order order) {
        return repo.remove(order);
    }

    // REMOVE an order by ID
    public boolean removeById(String orderId) {
        return repo.removeIf(o -> o.getId().equals(orderId));
    }

    // GET an order by index
    public Order get(int index) {
        if (index >= 0 && index < repo.size()) {
            return repo.get(index);
        }
        return null;
    }

    // GET all orders
    public List<Order> getAll() {
        return new ArrayList<>(repo);
    }
}
