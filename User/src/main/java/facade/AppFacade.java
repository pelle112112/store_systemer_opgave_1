package facade;

import controller.UserController;
import dto.UserDTO;

public class AppFacade {

    private final UserController controller;

    public AppFacade() {
        this.controller = new UserController();
    }

    /**
     * Returns true if login succeeds, false otherwise.
     */
    public boolean login(UserDTO dto) {
        return controller.login(dto);
    }
}
