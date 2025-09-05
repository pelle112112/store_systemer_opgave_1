package soft2.user.repository;

import java.util.HashMap;
import java.util.Map;


public class UserDAO {

    private final Map<String, String> users = new HashMap<>();

    public UserDAO() {
        users.put("alice", "password123");
        users.put("bob", "secret");
        users.put("charlie", "qwerty");
    }

    public boolean checkCredentials(String username, String password) {
        if (username == null || password == null) return false;
        String stored = users.get(username.toLowerCase());
        return password.equals(stored);
    }
}
