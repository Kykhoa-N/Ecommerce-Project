package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;

public class AuthService {

    private final UserRepo repo;

    public AuthService(UserRepo repo) {
        this.repo = repo;
    }

    public boolean register(String name, String id, Role role) {
        if(repo.findUser(id) == null) {
            repo.add(new User(name, id, role));
            return true;
        }
        return false;
    }

    public boolean login(String name, String id) {
        User user = repo.findUser(id);
        if(user == null) {
            return false;
        }
        return user.getName().equals(name);
    }

}
