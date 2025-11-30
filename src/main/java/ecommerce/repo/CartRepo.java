package ecommerce.repo;

import ecommerce.model.*;
import java.util.*;

public class CartRepo {

    // FIELD
    private List<Cart> repo;

    //Constructor
    public CartRepo() {
        this.repo = new ArrayList<>();
    }

    //Add a cart
    public void addItemToCart(Cart cart) {
        if (cart != null) {
            repo.add(cart);
        }
    }

    //Remove a cart
    public boolean removeItemFromCart(Cart cart) {
        return repo.remove(cart);
    }

    //Get cart by index
    public Cart get(int index)
        if(index >=0&&index<repo.size())

    {
        return repo.get(index);
    }
        return null;
}

    // GET all carts
    public List<Cart> getAll() {
        return new ArrayList<>(repo);
}