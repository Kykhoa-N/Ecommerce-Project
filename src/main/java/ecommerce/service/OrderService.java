package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;

import java.util.*;

public class OrderService {

    // FIELD
    private final OrderRepo repo;

    // CONSTRUCTOR
    public OrderService(OrderRepo repo) {
        this.repo = repo;
    }

    // VIEW ORDERS IN CATALOG
    public List<Order> viewAll(int view) {

        List<Order> catalog = repo.getAll();

        if(view == 0) {
            catalog.sort(Comparator.comparing(order -> order.getStatus().ordinal()));
        }
        else if(view == 1) {
            catalog.sort(Comparator.comparing(Order::getUserId));
        }
        else if (view == 2) {
            catalog.sort(Comparator.comparing(Order::getTimestamp));
        }

        return catalog;
    }

    // UPDATE AN ORDER STATUS
    public boolean update(String order_id, OrderStatus status) {
        Order order =  repo.getOrder(order_id);
        if(order == null) {
            return false;
        } {
            order.setStatus(status);
            return true;
        }
    }
}
