package ecommerce.repo;

import ecommerce.model.*;
import java.util.*;

public class ProductRepo {

    // FIELD
    private final List<Product> repo = new ArrayList<>();

    // REPO METHOD
    public void add(Product product) {
        repo.add(product);
    }

    //public void remove();
}
