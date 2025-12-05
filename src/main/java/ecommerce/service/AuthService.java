package ecommerce.service;

import ecommerce.model.*;
import ecommerce.repo.*;
import java.util.*;

public class AuthService {

    // FIELD
    private final UserRepo repo;

    // CONSTANT
    private static final Comparator<User> SORT_BY_ID = Comparator.comparing(User::getId);
    private static final Comparator<User> SORT_BY_ROLE = Comparator.comparing(user -> user.getRole().ordinal());

    // CONSTRUCTOR
    public AuthService(UserRepo repo) {
        this.repo = repo;
    }

    // METHOD

        // REGISTER USER
    public boolean register(String name, String id, Role role) {
        if(repo.getUser(id) == null) {
            return repo.add(new User(name, id, role));
        }
        return false;
    }

        // LOGIN USER
    public User login(String name, String id) {
        User user = repo.getUser(id);

        // if user doesn't exist or wrong name
        if(user == null || !user.getName().equals(name)) {
            return null;
        }
        return user;
    }

        // VIEW USER CATALOG
    public List<User> viewAll(int view) {
        List<User> catalog = repo.getAll();

        switch(view) {
            case 0 -> catalog.sort(SORT_BY_ID);
            case 1 -> catalog.sort(SORT_BY_ROLE);
        }
        return catalog;
    }

}
