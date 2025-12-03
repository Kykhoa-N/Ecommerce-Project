package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;

public class OrderService {

    private final OrderRepo repo;

    public OrderService(OrderRepo repo) {
        this.repo = repo;
    }

    public boolean viewAll() {

        for(Order order: repo.getAll()) {
            System.out.printf("%s %s %s%n", order.getId(), order.getUserId(), order.getStatus());
        }
        return true;
    }

    public boolean update() {
        return false;
    }
}
