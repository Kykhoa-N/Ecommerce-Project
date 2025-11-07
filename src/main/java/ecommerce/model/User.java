package ecommerce.model;

public class User {
    private final String id;
    private final String name;
    private final Role role;

    public User(String id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "USER: " + id + "\nNAME: " + name + "\nROLE: " + role + "\n";
    }
}