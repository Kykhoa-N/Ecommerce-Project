package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;

import java.util.*;

public class OrderService {

    private final OrderRepo repo;

    public OrderService(OrderRepo repo) {
        this.repo = repo;
    }

    public boolean viewAll() {
        List<Order> copy = new ArrayList<>(repo.getAll());
        copy.sort(Comparator.comparing(order -> order.getStatus().ordinal()));

        System.out.println("- ORDER CATALOG -");
        for(Order order: copy) {
            System.out.printf("     %-15s %-15s %-15s%n", order.getStatus(), order.getId(), order.getUserId());
        }
        return true;
    }

    public boolean update(String order_id, OrderStatus status) {
        return repo.update(order_id, status);
    }
}
