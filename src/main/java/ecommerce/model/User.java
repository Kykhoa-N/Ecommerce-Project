package ecommerce.model;

public class User {

    // FIELD
    private final String name;
    private final String id;
    private final Role role;

    // CONSTRUCTOR
    public User(String name, String id, Role role) {
        this.name = name;
        this.id = id;
        this.role = role;
    }

    // DATABASE HELPER METHOD
    public User(String csvLine) {
        String[] parts = csvLine.split(",");
        this.id   = parts[0];
        this.name = parts[1];
        this.role = Role.valueOf(parts[2].trim().toUpperCase());
    }
    public String toDataString() {
        return id + "," + name + "," + role;
    }

    // GETTER METHOD
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }
}