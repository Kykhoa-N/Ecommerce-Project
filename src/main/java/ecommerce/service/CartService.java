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
            repo.add(new Cart(user.getId()));
        }
        return false;
    }

    public boolean remove() {
        return false;
    }

    public boolean viewAll() {
        return false;
    }
}
