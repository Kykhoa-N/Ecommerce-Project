package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;

import java.util.*;

public class OrderService {

    // FIELD
    private final OrderRepo orderRepo;

    // CONSTANT
    private static final Comparator<Order> SORT_BY_STATUS = Comparator.comparing(order -> order.getStatus().ordinal());
    private static final Comparator<Order> SORT_BY_USER = Comparator.comparing(Order::getUserId);
    private static final Comparator<Order> Sort_BY_TIME = Comparator.comparing(Order::getTimestamp);

    // CONSTRUCTOR
    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    // UPDATE AN ORDER STATUS
    public boolean update(String order_id, OrderStatus status) {
        Order order =  orderRepo.getOrder(order_id);

        if(order == null) {
            return false;
        }
        else {
            order.setStatus(status);
            return true;
        }
    }

    // VIEW ORDER CATALOG
    public List<Order> viewAll(int view) {
        List<Order> catalog = orderRepo.getAll();

        switch(view) {
            case 0 -> catalog.sort(SORT_BY_STATUS);
            case 1 -> catalog.sort(SORT_BY_USER);
            case 3 -> catalog.sort(Sort_BY_TIME);
            default -> {
            }
        }
        return catalog;
    }
}
