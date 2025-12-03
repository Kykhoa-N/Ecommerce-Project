package ecommerce.service;

import ecommerce.model.Order;
import ecommerce.repo.OrderRepo;
import ecommerce.repo.ProductRepo;

import java.util.HashMap;
import java.util.Map;

public class ReportService {

    private final OrderRepo orders;
    private final ProductRepo products;

    public ReportService(OrderRepo orders, ProductRepo products) {
        this.orders = orders;
        this.products = products;
    }

    /** Fix Method Because of OrderRepo Class*/
    /*
    // Returns true if there are NO orders in the system.
    public boolean viewEmpty() {
        return orders.getAll().isEmpty();
    }

    //View all orders — returns true if there is at least 1 order.
    public boolean viewOrders() {
        return !orders.getAll().isEmpty();
    }

    //Returns true if at least one product has total quantity sold > 1.
    public boolean viewPopular() {
        Map<String, Integer> soldCount = new HashMap<>();

        for (Order o : orders.getAll()) {
            for (Map.Entry<String, Integer> entry : o.getProductList().entrySet()) {
                String productId = entry.getKey();
                int quantity = entry.getValue();
                soldCount.merge(productId, quantity, Integer::sum);
            }
        }

        return soldCount.values().stream().anyMatch(q -> q > 1);
    }

    //Returns true if revenue > 0.
    public boolean viewRevenue() {
        double total = 0.0;

        for (Order o : orders.getAll()) {
            total += o.getTotalPrice();
        }

        return total > 0.0;
    }

     */
}
