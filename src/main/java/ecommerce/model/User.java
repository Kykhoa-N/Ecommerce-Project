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

    // GETTER METHODS
    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    // PRINT TEST
    @Override
    public String toString() {
        return "NAME: " + name + "\nUSER: " + id + "\nROLE: " + role + "\n";
    }
}