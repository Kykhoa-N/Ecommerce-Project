package ecommerce.repo;

import ecommerce.model.*;
import java.util.*;

public class CartRepo {

    // FIELD
    private final List<Cart> repo = new ArrayList<>();
    ;

    // REPO METHOD
    public boolean add(Cart cart) {
        return repo.add(cart);
    }

    public boolean remove(String user_id) {
        for (Cart cart : repo) {
            if (cart.getUserId().equals(user_id)) {
                return repo.remove(cart);
            }
        }
        return false;
    }

    //Get cart by index
    public Cart get(String user_id) {
        for (Cart cart : repo) {
            if (cart.getUserId().equals(user_id)) {
                return cart;
            }
        }
        return null;
    }

    public List<Cart> getRepo() {
        return repo;
    }
}