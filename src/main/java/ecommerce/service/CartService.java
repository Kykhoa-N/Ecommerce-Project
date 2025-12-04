package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;
import java.util.*;

public class CartService {

    // FIELD
    private final CartRepo repo;

    // CONSTRUCTOR
    public CartService(CartRepo repo) {
        this.repo = repo;
    }

    // METHOD

        // ADD ITEM TO CART
    public boolean add(User user, String product, int quantity) {
        Cart cart = repo.getCart(user.getId());
        if(cart == null) {
            cart = new Cart(user.getId());
            repo.add(cart);
        }
        return cart.add(product, quantity);
    }

        // REMOVE ITEM FROM CART
    public boolean remove(User user, String product, int quantity) {
        Cart cart = repo.getCart(user.getId());
        return cart.remove(product, quantity);
    }

        // VIEW ITEMS OF CART
    public List<List<String>> viewAll(User user) {
        Cart cart = repo.getCart(user.getId());
        List<List<String>> cart_items = new ArrayList<>();

        if(cart == null) {
            cart = new Cart(user.getId());
            repo.add(cart);
        }

        for(Map.Entry<String, Integer> item: cart.getProductList().entrySet()) {
            cart_items.add(List.of(Integer.toString(item.getValue()), item.getKey()));
        }
        return cart_items;
    }
}
