package ecommerce.model;

public class User {
    private String id;
    private String name;
    private Role role;

    public User(String id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User:\n" + id + "\n" + name + "\n" + role + "\n";
    }
}