package ecommerce.repo;

import ecommerce.model.*;
import java.util.*;

// FILE IMPORTS
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class UserRepo {

    // FIELD
    private final List<User> repo = new ArrayList<>();

    // FILE FIELD
    private static final String USER_DATABASE_PATH = "src/main/java/ecommerce/database/UserDatabase.txt";

    // FILE CONSTRUCTOR
    public UserRepo() {
        loadFromFile();   // load database into repo
    }


    // REPO METHOD
    public boolean add(User user) {
        boolean added = repo.add(user);

        // FILE ADD TO DATABASE
        if (added)appendUserToFile(user);

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

    // FILE WRITER METHOD
    private void appendUserToFile(User user) {
        try {
            // make sure the /database folder exists
            File database_file = new File("src/main/java/ecommerce/database");
            if (!database_file.exists()) {
                database_file.mkdirs();
            }

            // open file in APPEND mode (true)
            try (FileWriter writer = new FileWriter(USER_DATABASE_PATH, true)) {
                writer.write(
                        user.getName() + "," +
                                user.getId() + "," +
                                user.getRole() + "\n"
                );
            }

            // optional: debug print so you can see it's working
            System.out.println("Saved user to file: " + user.getName());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // FILE READER METHOD
    private void loadFromFile() {

        File file = new File(USER_DATABASE_PATH);
        if (!file.exists()) {
            // no file yet = no users yet, that's fine
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {

                if (line.isBlank()) continue; // skip empty lines

                String[] parts = line.split(",");
                if (parts.length != 3) continue; // invalid line, skip

                String name = parts[0];
                String id   = parts[1];
                Role role   = Role.valueOf(parts[2]);

                // load into memory list
                repo.add(new User(name, id, role));
            }

            System.out.println("Loaded users from file: " + repo.size());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
