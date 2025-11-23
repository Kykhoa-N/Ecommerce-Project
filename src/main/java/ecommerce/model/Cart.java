package ecommerce.model;
import java.util.HashMap;
import java.util.Map;

public class Cart {

    // FIELD
    private final String user_id;
    private final Map<String, Integer> product_list;
    private final String address;

    // CONSTRUCTOR
    public Cart(String user_id, String address) {
        this.user_id = user_id;
        this.product_list = new HashMap<>();
        this.address = address;
    }

    // GETTER METHOD
    public String getUserId() {
        return user_id;
    }

    public Map<String, Integer> getProductList() {
        return product_list;
    }

    public String getAddress() {
        return address;
    }



}
