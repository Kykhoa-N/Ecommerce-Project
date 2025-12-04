package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;
import java.util.*;

public class ProductService {

    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;
    private final CartRepo cartRepo;

    public ProductService(ProductRepo productRepo, OrderRepo orderRepo, CartRepo cartRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
        this.cartRepo = cartRepo;
    }

    // ADD PRODUCT
    public boolean add(String name, String category, double price, int quantity) {
        if (name == null || category == null || price < 0 || quantity < 0) return false;
        Product p = new Product(name, category, price, quantity);
        return productRepo.add(p);
    }

    // UPDATE PRODUCT
    public boolean update(String name, String newCategory, Double newPrice, Integer newQty) {
        Product p = productRepo.getProduct(name);
        if (p == null) return false;

        if (newCategory != null) p.setCategory(newCategory);
        if (newPrice != null && newPrice >= 0) p.setPrice(newPrice);
        if (newQty != null && newQty >= 0) p.setQuantity(newQty);

        return true;
    }

    // REMOVE PRODUCT
    public boolean remove(String name) {
        return productRepo.remove(name);
    }

    // SEARCH by name
    public Product search(String name) {
        return productRepo.getProduct(name);
    }

    // SORT by price
    public List<Product> sortPrice() {
        List<Product> list = new ArrayList<>(productRepo.getAll());
        list.sort(Comparator.comparingDouble(Product::getPrice));
        return list;
    }

    // VIEW ALL PRODUCTS
    public List<Product> viewAll() {
        return new ArrayList<>(productRepo.getAll());
    }

    // FILTER products cheaper than given price
    public List<Product> filterPrice(double maxPrice) {
        List<Product> result = new ArrayList<>();
        for (Product p : productRepo.getAll()) {
            if (p.getPrice() <= maxPrice) {
                result.add(p);
            }
        }
        return result;
    }

    // CHECKOUT CLIENT CART
    public boolean checkout(User user, String tax) {
        Cart cart = cartRepo.getCart(user.getId());

        if(cart == null || cart.getProductList().isEmpty()) {
            return false;
        }
        else {
            // calculate total price and reduce stock
            double price = 0.00;

            for(Map.Entry<String, Integer> item: cart.getProductList().entrySet()) {

                Product product = productRepo.getProduct(item.getKey());

                // add item price to total price
                double item_price = product.getPrice();
                price += item_price * item.getValue();

                // reduce product quantity from stock
                product.setQuantity(product.getQuantity()-item.getValue());
            }
            price *= (1 + (Double.parseDouble(tax)/100));

            // creates order adds it to catalog and remove cart
            Order order = new Order(user.getId(), cart.getProductList(), price);
            orderRepo.add(order);
            return cartRepo.remove(user.getId());
        }
    }
    /** Fix Checkout because the product_list is a Hashmap not a List
     *  Fix Order History to use the getAll() to grab the information */
    /*
    // CHECKOUT
    public boolean checkout(String userId, List<String> productNames) {
        if (productNames == null || productNames.isEmpty()) return false;

        double total = 0.0;
        List<String> purchasedProducts = new ArrayList<>();

        for (String name : productNames) {
            Product p = repo.getProduct(name);
            if (p == null || p.getQuantity() <= 0) return false;

            // Reduce product quantity
            p.setQuantity(p.getQuantity() - 1);
            total += p.getPrice();

            // Track purchased products
            purchasedProducts.add(name);
        }

        // Create an order using the list of product names
        Order order = new Order(userId, purchasedProducts, total);
        return orders.add(order);
    }

    // ORDER HISTORY
    public List<Order> orderHistory(String userId) {
        return orders.getByUser(userId);
    }
     */
}
