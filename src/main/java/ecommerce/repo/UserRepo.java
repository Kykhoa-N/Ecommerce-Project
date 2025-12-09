package ecommerce.repo;

import ecommerce.model.*;
import java.util.*;
import ecommerce.uiHelper.*;

public class UserRepo {

    // FIELD
    private final List<User> repo = new ArrayList<>();

    // DATABASE HELPER METHOD
    private static final String USER_DATABASE_PATH = "src/main/java/ecommerce/database/UserDatabase.txt";

    public UserRepo() {
        repo.addAll(FileDBLoader.load(USER_DATABASE_PATH, User::new));
    }

    // REPO METHOD
    public boolean add(User user) {
        boolean added = repo.add(user);

        // add to database
        if (added) FileDBWriter.appendLine(USER_DATABASE_PATH, user.toDataString());

        return added;
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
