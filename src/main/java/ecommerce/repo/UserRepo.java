package ecommerce.repo;

import ecommerce.model.*;
import java.util.*;

public class UserRepo {

    // FIELD
    private final List<User> repo = new ArrayList<>();

    // REPO METHOD
    public boolean add(User user) {
        return repo.add(user);
    }

    public User getUser(String id) {
        for(User user: repo) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public List<User> getAll() {
        return new ArrayList<>(repo);
    }
}
