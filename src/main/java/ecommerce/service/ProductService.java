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

    // ORDER HISTORY
    public List<Order> orderHistory(User user) {
        return orderRepo.getHistory(user.getId());
    }
}
