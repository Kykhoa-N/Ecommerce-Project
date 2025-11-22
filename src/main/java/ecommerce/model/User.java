package ecommerce.model;

public class User {
    private final String name;
    private final String id;
    private final Role role;

    public User(String name, String id, Role role) {
        this.name = name;
        this.id = id;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "NAME: " + name + "\nUSER: " + id + "\nROLE: " + role + "\n";
    }
}