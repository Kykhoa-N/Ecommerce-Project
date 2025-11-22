package ecommerce.app;

import ecommerce.model.*;
import ecommerce.repo.UserRepo;

public class Main {
    public static void main(String[] args) {
        User admin = new User( "kykhoa", "kn1029928", Role.ADMIN);
        User client = new User("nicole","tn1029928", Role.CLIENT);

        UserRepo userRepo = new UserRepo();

        userRepo.add(admin);
        userRepo.add(client);

        System.out.println(userRepo);
    }
}