package ecommerce.repo;
import ecommerce.model.User;

import java.util.HashMap;
import java.util.Map;

public class UserRepo {

    private final Map<String, User> users_by_id = new HashMap<>();

    public void add(User user) {
        if(users_by_id.containsKey(user.getId())){
            System.out.println("TRY AGAIN");
        } else {
            users_by_id.put(user.getId(), user);
        }
    }

    @Override
    public String toString() {
        String output = "";
        for(User user: users_by_id.values()) {
            output += user + "\n";
        }
        return output;
    }
}
