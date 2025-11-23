package ecommerce.model;

import java.util.*;
import java.time.*;

public class Order {

    // FIELD
    private final String id;
    private final String user_id;
    private final Map<String, Integer> product_list;
    private final double total_price;
    private final LocalDateTime timestamp;
    private OrderStatus status;

    // CONSTRUCTOR
    public Order(String user_id, Map<String, Integer> product_list, double total_price) {
        this.id = user_id + " ID NUMBER AMOUNT";
        this.user_id = user_id;
        this.product_list = product_list;
        this.total_price = total_price;
        this.timestamp = LocalDateTime.now();
        this.status = OrderStatus.PROCESSED;
    }

    // GETTER METHOD
    public String getId() {
        return id;
    }

    public  String getUserId() {
        return user_id;
    }

    public Map<String, Integer> getProductList() {
        return product_list;
    }

    public double getTotalPrice() {
        return total_price;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public OrderStatus getStatus() {
        return status;
    }

    // SETTER METHOD
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
