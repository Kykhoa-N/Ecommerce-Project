package ecommerce.repo;

import ecommerce.model.*;
import java.util.*;

// FILE IMPORTS
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class CartRepo {

    // FIELD
    private final List<Cart> repo = new ArrayList<>();

    // REPO METHOD
    public void add(Cart cart) {
        repo.add(cart);
    }

    public boolean remove(String user_id) {
        for (Cart cart : repo) {
            if (cart.getUserId().equals(user_id)) {
                return repo.remove(cart);
            }
        }
        return false;
    }

    public Cart getCart(String user_id) {
        for (Cart cart : repo) {
            if (cart.getUserId().equals(user_id)) {
                return cart;
            }
        }
        return null;
    }

    public List<Cart> getAll() {
        return new ArrayList<>(repo);
    }
}