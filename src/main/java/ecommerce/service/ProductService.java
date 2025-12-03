package ecommerce.service;

import ecommerce.model.Product;
import ecommerce.model.Order;
import ecommerce.repo.ProductRepo;
import ecommerce.repo.OrderRepo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /** Fix Method Because of OrderRepo Class*/
    /*
    public boolean checkout(String userId, List<String> productNames) {
        if (productNames == null || productNames.isEmpty()) return false;

        double total = 0.0;
        Map<String, Integer> productMap = new HashMap<>();

        // Reduce quantities and build product map
        for (String name : productNames) {
            Product p = repo.getProduct(name);
            if (p == null || p.getQuantity() <= 0) return false;

            p.setQuantity(p.getQuantity() - 1);
            total += p.getPrice();

            productMap.put(name, productMap.getOrDefault(name, 0) + 1);
        }

        // Create order with Map
        Order order = new Order(userId, productMap, total);
        return orders.add(order);
    }

    // ORDER HISTORY
    public List<Order> orderHistory(String userId) {
        List<Order> result = new ArrayList<>();
        for (Order o : orders.getAll()) {
            if (o.getUserId().equals(userId)) {
                result.add(o);
            }
        }
        return result;
    }
     */
}
