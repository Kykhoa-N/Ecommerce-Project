package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;

import java.util.ArrayList;

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
        if(cart == null) {
            return false;
        } else {
            return cart.remove(product, quantity);
        }
    }

    public boolean viewAll() {
        return false;
    }
}
