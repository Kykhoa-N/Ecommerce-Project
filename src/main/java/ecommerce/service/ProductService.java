package ecommerce.service;

import ecommerce.model.Product;
import ecommerce.repo.ProductRepo;

public class ProductService {

    private final ProductRepo repo;

    public ProductService(ProductRepo repo) {
        this.repo = repo;
    }

    // ADD
    public boolean addProduct(String name, String category, double price, int quantity) {
        if (name == null || category == null || price < 0 || quantity < 0) return false;
        Product p = new Product(name, category, price, quantity);
        return repo.add(p);
    }

    // READ
    public Product getProduct(String name) {
        return repo.getProduct(name);
    }

    // DELETE
    public boolean deleteProduct(String name) {
        return repo.remove(name);
    }

    // UPDATE PRICE
    public boolean updatePrice(String name, double newPrice) {
        Product p = repo.getProduct(name);
        if (p == null || newPrice < 0) return false;
        p.setPrice(newPrice);
        return true;
    }

    // UPDATE CATEGORY
    public boolean updateCategory(String name, String newCategory) {
        Product old = repo.getProduct(name);
        if (old == null || newCategory == null) return false;

        // create a NEW product
        Product updated = new Product(
                old.getName(),
                newCategory,
                old.getPrice(),
                old.getQuantity()
        );

        repo.remove(old.getName());
        repo.add(updated);

        return true;
    }

    // UPDATE QUANTITY
    public boolean updateQuantity(String name, int newQty) {
        Product p = repo.getProduct(name);
        if (p == null || newQty < 0) return false;
        p.setQuantity(newQty);
        return true;
    }
}
