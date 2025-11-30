package ecommerce.repo;

import ecommerce.model.*;
import java.util.*;

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

    public List<Product> getRepo() {
        return repo;
    }
}
