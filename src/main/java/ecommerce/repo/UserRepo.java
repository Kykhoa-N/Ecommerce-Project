package ecommerce.repo;

import ecommerce.model.*;
import java.util.*;

public class UserRepo {

    // FIELD
    private final List<User> repo = new ArrayList<>();

    // LIST METHOD
    public void add(User user) {
        repo.add(user);
    }

    public void getAll() {
        System.out.println("___________ ACCOUNTS ___________");
        for(User user: repo) {
            System.out.printf("%10s %12s %8s%n", user.getName(), user.getId(), user.getRole());
        }
    }

}
