package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;

public class AuthService {

    private final UserRepo userRepo;

    public AuthService(UserRepo repo) {
        this.userRepo = repo;
    }

    public boolean register(String name, String id, Role role) {
        User user = new User(name, id, role);
        userRepo.add(user);
        return false;
    }

    public boolean login() {
        return false;
    }

    public void getRepo() {
        System.out.println(userRepo);
    }
}
