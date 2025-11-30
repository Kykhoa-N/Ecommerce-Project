package ecommerce.repo;

import ecommerce.model.*;
import java.util.*;

public class OrderRepo {

    // FIELD
    private final List<Order> repo = new ArrayList<>();

    // REPO METHOD
    public boolean add(Order order) {
        return repo.add(order);
    }

    public Order getOrder(String id) {
        for(Order order: repo) {
            if(order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }

    public List<Order> getRepo() {
        return repo;
    }
}
