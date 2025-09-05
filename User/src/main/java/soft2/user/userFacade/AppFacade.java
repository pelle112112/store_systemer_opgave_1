package soft2.user.userFacade;

import soft2.user.controller.UserController;
import soft2.user.dto.UserDTO;

public class AppFacade {

    private final UserController controller;

    public AppFacade() {
        this.controller = new UserController();
    }

    /**
     * Returns true if login succeeds, false otherwise.
     */
    public boolean login(String username, String password) {
        UserDTO dto = new UserDTO(username, password);
        return controller.login(dto);
    }
}
