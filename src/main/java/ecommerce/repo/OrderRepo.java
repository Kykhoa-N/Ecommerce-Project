package ecommerce.repo;

import ecommerce.model.*;
import java.util.*;

// FILE IMPORTS
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class OrderRepo {

    // FIELD
    private final List<Order> repo = new ArrayList<>();;

    // REPO METHOD
    public boolean add(Order order) {
        return repo.add(order);
    }

    public Order getOrder(String id) {
        for(Order order: repo) {
            if(order.getId().equals(id)){
                return order;
            }
        }
        return null;
    }

    public List<Order> getHistory(String id) {
        List<Order> history = new ArrayList<>();
        for(Order order: repo) {
            if(order.getUserId().equals(id)){
                history.add(order);
            }
        }
        return history;
    }

    public List<Order> getAll() {
        return new ArrayList<>(repo);
    }
}
