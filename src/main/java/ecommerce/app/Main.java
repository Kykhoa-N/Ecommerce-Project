package ecommerce.app;

import ecommerce.model.*;
import ecommerce.repo.UserRepo;

public class Main {
    public static void main(String[] args) {
        User admin = new User("kn1029928", "kykhoa", Role.ADMIN);
        User client = new User("tn1029928", "nicole", Role.CUSTOMER);

        UserRepo userRepo = new UserRepo();

        userRepo.add(admin);
        userRepo.add(client);

        System.out.println(userRepo);
    }
}