package ecommerce.app;

import ecommerce.model.*;
import ecommerce.repo.UserRepo;

public class Main {
    public static void main(String[] args) {
        User admin = new User( "kykhoa", "kn1029928", Role.ADMIN);
        User client = new User("nicole","kn1029928", Role.CLIENT);

        UserRepo userRepo = new UserRepo();

        System.out.println(userRepo);
    }
}