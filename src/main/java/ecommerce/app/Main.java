package ecommerce.app;

import ecommerce.model.*;
import ecommerce.repo.*;
import ecommerce.service.AuthService;
import ecommerce.service.CartService;
import ecommerce.service.OrderService;
import ecommerce.service.ProductService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        UserRepo userRepo = new UserRepo();
        CartRepo cartRepo = new CartRepo();
        OrderRepo orderRepo = new OrderRepo();
        ProductRepo productRepo = new ProductRepo();

        AuthService auth = new AuthService(userRepo);
        CartService cart = new CartService(cartRepo, productRepo);
        OrderService order = new OrderService(orderRepo);
        ProductService prod = new ProductService(productRepo, orderRepo, cartRepo);

        auth.register("kyanh", "ktn5110", Role.CLIENT);
        auth.register("kykhoa", "kn1029928", Role.CLIENT);
        auth.register("jacob", "ja213214", Role.ADMIN);
        auth.register("nicole", "no1029928", Role.CLIENT);

        User user1 = userRepo.getUser(userRepo.getAll().get(1).getId());
        User user2 = userRepo.getUser(userRepo.getAll().get(2).getId());


        cart.add(user1, "apple", 40);
        cart.add(user1, "oranges", 4);
        cart.add(user1, "banana", 12);
        cart.remove(user1, "banana", 10);

        Cart cart1 = cartRepo.getAll().getFirst();


        Order order1 = new Order(1, userRepo.getAll().get(0).getId(), cart1.getProductList(), 35.00);
        Order order2 = new Order(2, userRepo.getAll().get(1).getId(), cart1.getProductList(), 45.00);
        Order order3 = new Order(3, userRepo.getAll().get(2).getId(), cart1.getProductList(), 15.00);
        Order order4 = new Order(4, userRepo.getAll().get(3).getId(), cart1.getProductList(), 15.00);
        Order order5 = new Order(5, userRepo.getAll().get(1).getId(), cart1.getProductList(), 15.00);
        orderRepo.add(order1);
        orderRepo.add(order2);
        orderRepo.add(order3);
        orderRepo.add(order4);
        orderRepo.add(order5);

        order.update(user2, order3.getId(), OrderStatus.DELIVERED);

        System.out.println(order.viewAll(user1, 0));

        for(Order c: order.viewAll(user2, 0)) {
            System.out.printf("%-15s %-15s%n", c.getStatus(), c.getId());
        }

    }
}