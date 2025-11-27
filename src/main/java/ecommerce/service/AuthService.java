package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;

public class AuthService {

    private final UserRepo repo;

    public AuthService(UserRepo repo) {
        this.repo = repo;
    }

    public void register(String name, String id, Role role) {
        if(repo.getUser(name) == null) {
            repo.add(new User(name, id, role));
            System.out.println("ACCOUNT REGISTERED");
        }
        else {
            System.out.println("TRY AGAIN");
        }
    }

    public boolean login() {
        return false;
    }

}
