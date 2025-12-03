package ecommerce.app;

import ecommerce.model.*;
import ecommerce.repo.*;
import ecommerce.service.AuthService;
import ecommerce.service.CartService;
import ecommerce.service.OrderService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        UserRepo userRepo = new UserRepo();
        CartRepo cartRepo = new CartRepo();
        OrderRepo orderRepo = new OrderRepo();
        ProductRepo productRepo = new ProductRepo();

        AuthService auth = new AuthService(userRepo);
        CartService cart = new CartService(cartRepo);
        OrderService order = new OrderService(orderRepo);

        auth.register("kyanh", "ktn5110", Role.ADMIN);
        auth.register("kykhoa", "kn1029928", Role.ADMIN);
        auth.register("jacob", "kn1029928", Role.ADMIN);
        auth.register("nicole","no1029928", Role.CLIENT);

        User user = new User("nicole","no1029928", Role.CLIENT);

        cart.add(user, "apple", 40);
        cart.add(user, "oranges", 4);
        cart.add(user, "banana", 12);
        //cart.remove(user, "apple", 10);
        cart.remove(user, "banana", 10);
        //cart.remove(user, "oranges", 10);

        System.out.println(cart.viewAll(user));
    }
}