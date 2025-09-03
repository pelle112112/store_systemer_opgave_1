package repository;

import dto.UserDTO;
import org.eclipse.jetty.server.Authentication;

public class UserDAO {

    public UserDTO getUserById(int id) {
        // Dummy implementation
        switch (id){
            case 1:
                UserDTO user1 = new UserDTO("MadsPetersen1234", "MadsP@live.dk");
                // Set properties for user1
                return user1;
            case 2:
                UserDTO user2 = new UserDTO("LauraJensen", "LauraJ@hotmail.com");
                // Set properties for user2
                return user2;
            default:
                return null;

        }
    }
}
