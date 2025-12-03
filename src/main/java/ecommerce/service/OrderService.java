package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;

public class OrderService {

    private final OrderRepo repo;

    public OrderService(OrderRepo repo) {
        this.repo = repo;
    }

    public boolean viewAll() {

        return false;
    }

    public boolean update() {
        return false;
    }
}
