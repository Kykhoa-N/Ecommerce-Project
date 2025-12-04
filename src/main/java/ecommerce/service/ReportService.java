package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;

import java.util.List;

public class ReportService {

    private final OrderRepo orders;
    private final ProductRepo products;

    public ReportService(OrderRepo orders, ProductRepo products) {
        this.orders = orders;
        this.products = products;
    }

    // Returns true if there are NO orders in the system.
    public boolean viewEmpty() {
        return orders.getAll().isEmpty();
    }

    // Returns true if there is at least one order.
    public boolean viewOrders() {
        return !orders.getAll().isEmpty();
    }

    // Returns true if at least one product has been sold more than once.
    public boolean viewPopular() {
        List<Order> allOrders = orders.getAll();

        for (Order o1 : allOrders) {
            for (String productId : o1.getProductList().keySet()) {
                int totalQuantity = 0;

                // Count how many times this product appears in all orders
                for (Order o2 : allOrders) {
                    Integer qty = o2.getProductList().get(productId);
                    if (qty != null) {
                        totalQuantity += qty;
                    }
                }

                if (totalQuantity > 1) {
                    return true;
                }
            }
        }

        return false;
    }

    // Returns true if total revenue > 0.
    public boolean viewRevenue() {
        double total = 0.0;
        for (Order o : orders.getAll()) {
            total += o.getTotalPrice();
        }
        return total > 0.0;
    }
}
