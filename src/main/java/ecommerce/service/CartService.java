package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;
import java.util.*;

public class CartService {

    // FIELD
    private final CartRepo cartRepo;
    private final ProductRepo productRepo;

    // CONSTRUCTOR
    public CartService(CartRepo cartRepo, ProductRepo productRepo) {
        this.cartRepo = cartRepo;
        this.productRepo = productRepo;
    }

    // METHOD

        // ADD ITEM TO CART
    public boolean add(User user, String product, int quantity) {
        Cart cart = cartRepo.getCart(user.getId());

        if(cart == null) {
            cart = new Cart(user.getId());
            cartRepo.add(cart);
        }
        return cart.add(product, quantity);
    }

        // REMOVE ITEM FROM CART
    public boolean remove(User user, String product, int quantity) {
        Cart cart = cartRepo.getCart(user.getId());
        return cart.remove(product, quantity);
    }

        // VIEW CART CATALOG
    public List<CartItem> viewAll(User user) {
        List<CartItem> catalog = new ArrayList<>();
        Cart cart = cartRepo.getCart(user.getId());

        if(cart == null) {
            cart = new Cart(user.getId());
            cartRepo.add(cart);
        }

        for(Map.Entry<String, Integer> item: cart.getProductList().entrySet()) {
            catalog.add(new CartItem(item.getKey(), item.getValue()));
        }
        return catalog;
    }
}
