package ecommerce.model;
import java.util.Map;

public class Order {
    private String id;
    private String user_id;
    private Map<String, Integer> product_list;
    private double total_price;
    private int timestamp;
    private OrderStatus status;
}
