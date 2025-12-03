package ecommerce.repo;

import ecommerce.model.Order;
import ecommerce.model.Product;

import java.util.*;

public class OrderRepo {

    // FIELD
    private final List<Order> repo = new ArrayList<>();;

    // REPO METHOD
    public boolean add(Order order) {
        if (order == null) return false;
        return repo.add(order);
    }

    // GET ORDER BY ID
    public Optional<Order> get(String id) {
        if (id == null) return Optional.empty();
        return repo.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst();
    }

    // Get All
    public List<Order> getAll() {
        return new ArrayList<>(repo);
    }

    // GET ALL ORDERS FOR A SPECIFIC USER
    public List<Order> getByUser(String userId) {
        List<Order> result = new ArrayList<>();
        for (Order order : repo) {
            if (order.getUserId().equals(userId)) {
                result.add(order);
            }
        }
        return result;
    }

    // UPDATE ORDER (mainly status)
    public boolean update(Order order) {
        if (order == null) return false;

        for (int i = 0; i < repo.size(); i++) {
            if (repo.get(i).getId().equals(order.getId())) {
                repo.set(i, order);
                return true;
            }
        }
        return false;
    }

    // REMOVE ORDER
    public boolean remove(String id) {
        return repo.removeIf(o -> o.getId().equals(id));
    }
}
