package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;
import java.util.*;

public class ProductService {

    // FIELD
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;
    private final CartRepo cartRepo;

    // CONSTANT
    private static final Comparator<Product> SORT_BY_NAME = Comparator.comparing(Product::getName);
    private static final Comparator<Product> SORT_BY_PRICE = Comparator.comparing(Product::getPrice);
    private static final Comparator<Product> SORT_BY_CATEGORY = Comparator.comparing(Product::getCategory);

    // CONSTRUCTOR
    public ProductService(ProductRepo productRepo, OrderRepo orderRepo, CartRepo cartRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
        this.cartRepo = cartRepo;
    }

    // ADMIN METHOD

        // ADD PRODUCT
    public boolean add(String name, String category, double price, int quantity) {
        // doesn't create product if wrong parameters or product already existed
        if (name == null || category == null || price < 0 || quantity < 0 || !(productRepo.getProduct(name) == null)) {
            return false;
        }
        return productRepo.add(new Product(name, category, price, quantity));
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

        // SEARCH FOR PRODUCT
    public Product search(String name) {
        return productRepo.getProduct(name);
    }

        // SORT PRICE
    public List<Product> sortPrice() {
        List<Product> catalog = productRepo.getAll();
        catalog.sort(SORT_BY_PRICE);
        return catalog;
    }

        // VIEW PRODUCT CATALOG
    public List<Product> viewAll() {
        return productRepo.getAll();
    }

    // CLIENT METHOD

        // VIEW STORE
    public List<Product> viewAvailable() {
        return productRepo.getAll().stream()
                .filter(product -> product.getQuantity() > 0)
                .toList();
    }

        // FILTER PRICE BY BUDGET
    public List<Product> filterPrice(double max_price) {
        return productRepo.getAll().stream()
                .filter(product -> product.getQuantity() > 0)
                .filter(product -> product.getPrice() < max_price)
                .toList();
    }

        // CHECKOUT CLIENT CART
    public boolean checkout(User user, String tax) {
        Cart cart = cartRepo.getCart(user.getId());

        if(cart == null || cart.getProductList().isEmpty()) {
            return false;
        }
        else {
            // total price
            double price = 0.00;

            for(Map.Entry<String, Integer> item: cart.getProductList().entrySet()) {
                Product product = productRepo.getProduct(item.getKey());

                // add item price to total price
                double item_price = product.getPrice();
                price += item_price * item.getValue();

                // reduce product quantity from stock
                product.setQuantity(product.getQuantity()-item.getValue());
            }
            // calculate tax
            price *= (1 + (Double.parseDouble(tax)/100));

            // adds order to catalog and remove cart
            Order order = new Order(orderRepo.getHistory(user.getId()).size() + 1, user.getId(), cart.getProductList(), price);
            orderRepo.add(order);
            return cartRepo.remove(user.getId());
        }
    }

        // GET CLIENT ORDER HISTORY
    public List<Order> orderHistory(User user) {
        return orderRepo.getHistory(user.getId());
    }
}
