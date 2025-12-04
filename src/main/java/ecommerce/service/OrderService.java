package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;

import java.util.*;

public class OrderService {

    // FIELD
    private final OrderRepo repo;

    // CONSTANT
    private static final Comparator<Order> SORT_BY_STATUS = Comparator.comparing(order -> order.getStatus().ordinal());
    private static final Comparator<Order> SORT_BY_USER = Comparator.comparing(Order::getUserId);
    private static final Comparator<Order> Sort_BY_TIME = Comparator.comparing(Order::getTimestamp);

    // CONSTRUCTOR
    public OrderService(OrderRepo repo) {
        this.repo = repo;
    }

    // METHOD

        // VIEW ORDER CATALOG
    public List<Order> viewAll(int view) {
        List<Order> catalog = repo.getAll();

        switch(view) {
            case 0 -> catalog.sort(SORT_BY_STATUS);
            case 1 -> catalog.sort(SORT_BY_USER);
            case 3 -> catalog.sort(Sort_BY_TIME);
        }
        return catalog;
    }

        // UPDATE AN ORDER STATUS
    public boolean update(String order_id, OrderStatus status) {
        Order order =  repo.getOrder(order_id);

        if(order == null) {
            return false;
        }
        else {
            order.setStatus(status);
            return true;
        }
    }
}
