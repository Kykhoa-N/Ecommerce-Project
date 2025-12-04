package ecommerce.service;

import ecommerce.model.Product;
import ecommerce.model.Order;
import ecommerce.repo.ProductRepo;
import ecommerce.repo.OrderRepo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductService {

    private final ProductRepo repo;
    private final OrderRepo orders;

    public ProductService(ProductRepo repo, OrderRepo orders) {
        this.repo = repo;
        this.orders = orders;
    }

    // ADD PRODUCT
    public boolean add(String name, String category, double price, int quantity) {
        if (name == null || category == null || price < 0 || quantity < 0) return false;
        Product p = new Product(name, category, price, quantity);
        return repo.add(p);
    }

    // UPDATE PRODUCT
    public boolean update(String name, String newCategory, Double newPrice, Integer newQty) {
        Product p = repo.getProduct(name);
        if (p == null) return false;

        if (newCategory != null) p.setCategory(newCategory);
        if (newPrice != null && newPrice >= 0) p.setPrice(newPrice);
        if (newQty != null && newQty >= 0) p.setQuantity(newQty);

        return true;
    }

    // REMOVE PRODUCT
    public boolean remove(String name) {
        return repo.remove(name);
    }

    // SEARCH by name
    public Product search(String name) {
        return repo.getProduct(name);
    }

    // SORT by price
    public List<Product> sortPrice() {
        List<Product> list = new ArrayList<>(repo.getAll());
        list.sort(Comparator.comparingDouble(Product::getPrice));
        return list;
    }

    // VIEW ALL PRODUCTS
    public List<Product> viewAll() {
        return new ArrayList<>(repo.getAll());
    }

    // FILTER products cheaper than given price
    public List<Product> filterPrice(double maxPrice) {
        List<Product> result = new ArrayList<>();
        for (Product p : repo.getAll()) {
            if (p.getPrice() <= maxPrice) {
                result.add(p);
            }
        }
        return result;
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
