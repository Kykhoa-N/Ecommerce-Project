package ecommerce.repo;

import ecommerce.model.Order;
import ecommerce.model.Product;

import java.util.*;

public class OrderRepo {

    // FIELD
    private final List<Order> repo = new ArrayList<>();;

    // REPO METHOD
    public boolean add(Order order) {
        return repo.add(order);
    }

    public List<Order> getAll() {
        return new ArrayList<>(repo);
    }


    /** Fix Method Because repo convert from a Hashmap to an ArrayList */
    /*
    // ADD ORDER
    public boolean add(Order order) {
        if (order == null) return false;
        if (repo.containsKey(order.getId())) return false;
        repo.put(order.getId(), order);
        return true;
    }

    // GET ORDER BY ID
    public Optional<Order> get(String id) {
        if (id == null) return Optional.empty();
        return Optional.ofNullable(repo.get(id));
    }

    // GET ALL ORDERS
    public List<Order> getAll() {
        return new ArrayList<>(repo.values());
    }

    // GET ALL ORDERS FOR A SPECIFIC USER
    public List<Order> getByUser(String userId) {
        List<Order> result = new ArrayList<>();
        for (Order order : repo.values()) {
            if (order.getUserId().equals(userId)) {
                result.add(order);
            }
        }
        return result;
    }

    // UPDATE ORDER (mainly status)
    public boolean update(Order order) {
        if (order == null) return false;
        if (!repo.containsKey(order.getId())) return false;
        repo.put(order.getId(), order);
        return true;
    }

    // REMOVE ORDER
    public boolean remove(String id) {
        if (id == null) return false;
        return repo.remove(id) != null;
    }
     */
}
