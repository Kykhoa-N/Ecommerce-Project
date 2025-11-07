package main.java.ecommerce.model;
import java.util.Map;

public class Order {
    private String order_id;
    private String customer_id;
    private Map<Integer, Integer> items;
    private int total_qty;
    private double total_price;
    private int timestamp;
    private OrderStatus status;
}
