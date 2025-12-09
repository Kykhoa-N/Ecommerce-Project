package ecommerce.repo;

import ecommerce.model.*;
import java.util.*;

// FILE IMPORTS
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class ProductRepo {

    // FIELD
    private final List<Product> repo = new ArrayList<>();

    // REPO METHOD
    public boolean add(Product product) {
        return repo.add(product);
    }

    public boolean remove(String name) {
        for(Product product: repo) {
            if(product.getName().equals(name)) {
                return repo.remove(product);
            }
        }
        return false;
    }

    public Product getProduct(String name) {
        for(Product product: repo) {
            if(product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getAll() {
        return new ArrayList<>(repo);
    }
}
