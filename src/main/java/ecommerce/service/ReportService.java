package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;
import java.util.*;

public class ReportService {

    // FIELD
    private final OrderRepo orderRepo;
    private final ProductRepo productRepo;

    // CONSTRUCTOR
    public ReportService(OrderRepo orderRepo, ProductRepo productRepo) {
        this.orderRepo = orderRepo;
        this.productRepo = productRepo;
    }

    // VIEW EMPTY STOCKS
    public List<Product> viewEmpty() {
        return productRepo.getAll().stream()
                .filter(product -> product.getQuantity() <= 0)
                .toList();
    }

    // GET TOTAL ORDERS
    public int totalOrder() {
        return orderRepo.getAll().size();
    }

    // GET FREQUENT ORDER
    public Product getFrequent(User user) {
        List<Order> catalog = orderRepo.getAll();
        List<CartItem> frequent = new ArrayList<>();
        Cart cart = new Cart(user.getId());

        if(catalog.isEmpty()) return null;

        // count all orders product into cart
        for(Order order: catalog) {
            for(Map.Entry<String, Integer> item: order.getProductList().entrySet()) {
                cart.add(item.getKey(), item.getValue());
            }
        }

        // convert hashmap to list for display
        for(Map.Entry<String, Integer> item: cart.getProductList().entrySet()) {
            frequent.add(new CartItem(item.getKey(), item.getValue()));
        }

        if(frequent.isEmpty()) return null;

        // return largest quantity
        frequent.sort(Comparator.comparing(CartItem::getQuantity));
        return productRepo.getProduct(frequent.getLast().getProduct());
    }

    // CALCULATE REVENUE
    public Double totalRevenue() {
        return orderRepo.getAll().stream()
                .mapToDouble(Order::getTotalPrice)
                .sum();
    }
}
