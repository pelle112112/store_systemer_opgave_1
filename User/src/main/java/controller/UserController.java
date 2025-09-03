package controller;

import dto.UserDTO;
import service.UserService;

public class UserController {

    private final UserService service;

    public UserController() {
        this.service = new UserService();
    }

    public boolean login(UserDTO dto) {
        if (dto == null) return false;

        String username = dto.getUsername();
        String password = dto.getPassword();

        if (username == null || password == null) return false;
        username = username.trim();
        if (username.isEmpty()) return false;

        return service.authenticate(username, password);
    }
}
