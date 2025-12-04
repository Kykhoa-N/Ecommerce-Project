package ecommerce.model;

import java.util.*;


public class Cart {

    // FIELD
    private final String user_id;
    private final Map<String, Integer> product_list;

    // CONSTRUCTOR
    public Cart(String user_id) {
        this.user_id = user_id;
        this.product_list = new HashMap<>();
    }

    // GETTER METHOD
    public String getUserId() {
        return user_id;
    }

    public Map<String, Integer> getProductList() {
        return product_list;
    }

    // UTILITY METHOD
    public boolean add(String product, int quantity) {
        product_list.put(product, product_list.getOrDefault(product, 0) + quantity);
        return true;
    }

    public boolean remove(String product, int quantity) {
        if(product_list.get(product) == null) {
            return false;
        }
        else {
            int difference = product_list.get(product) - quantity;
            if(difference > 0) {
                product_list.put(product, difference);
            } else {
                product_list.remove(product);
            }
            return true;
        }
    }

}
