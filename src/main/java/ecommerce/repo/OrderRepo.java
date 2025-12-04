package ecommerce.repo;

import ecommerce.model.*;
import java.util.*;

public class OrderRepo {

    // FIELD
    private final List<Order> repo = new ArrayList<>();;

    // REPO METHOD
    public boolean add(Order order) {
        return repo.add(order);
    }

    public boolean update(String id, OrderStatus status) {
        for(Order order: repo) {
            if(order.getId().equals(id)) {
                order.setStatus(status);
                return true;
            }
        }
        return false;
    }

    public Order getOrder(String id) {
        for(Order order: repo) {
            if(order.getId().equals(id)){
                return order;
            }
        }
        return null;
    }

    public List<Order> getAll() {
        return new ArrayList<>(repo);
    }
}
