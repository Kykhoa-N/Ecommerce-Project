package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;

import java.util.ArrayList;
import java.util.Map;

public class CartService {

    private final CartRepo repo;

    public CartService(CartRepo repo) {
        this.repo = repo;
    }

    public boolean add(User user, String product, int quantity) {
        Cart cart = repo.getCart(user.getId());
        if(cart == null) {
            cart = new Cart(user.getId());
            repo.add(cart);
        }
        return cart.add(product, quantity);
    }

    public boolean remove(User user, String product, int quantity) {
        Cart cart = repo.getCart(user.getId());
        return cart.remove(product, quantity);
    }

    public boolean viewAll(User user) {
        Cart cart = repo.getCart(user.getId());
        if(cart == null || cart.getProductList().isEmpty()) {
            return false;
        } else {
            System.out.printf("%s CART%n", user.getName().toUpperCase());
            for(Map.Entry<String, Integer> item: cart.getProductList().entrySet()) {
                System.out.printf(" %4d %s%n", item.getValue(), item.getKey());
            }
            return true;
        }
    }
}
