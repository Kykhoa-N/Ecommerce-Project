package ecommerce.repo;

import ecommerce.model.*;
import java.util.*;

public class UserRepo {

    // FIELD
    private final List<User> repo = new ArrayList<>();

    // REPO METHOD
    public void add(User user) {
        repo.add(user);
    }

    public User getUser(String id) {
        for(User user: repo) {
            if(user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    public void getAll() {
        System.out.println("_______________ ACCOUNTS _______________");
        System.out.printf("%-16s %-16s %-8s%n", "USER", "USER", "ROLE");
        for(User user: repo) {
            System.out.printf("%-16s %-16s %-8s%n", user.getName(), user.getId(), user.getRole());
        }
    }

}
