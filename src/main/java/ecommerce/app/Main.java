package ecommerce.app;

import ecommerce.model.*;
import ecommerce.repo.*;
import ecommerce.service.AuthService;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        UserRepo userRepo = new UserRepo();
        AuthService auth = new AuthService(userRepo);

        auth.register("kyanh", "ktn5110", Role.ADMIN);
        auth.register("kykhoa", "kn1029928", Role.ADMIN);
        auth.register("nicole","kn1029928", Role.CLIENT);
        userRepo.getAll();
    }
}