package facade;

import repository.UserDAO;

public class RepositoryFacade {

    private final UserDAO userDAO;

    public RepositoryFacade() {
        this.userDAO = new UserDAO();
    }

    public boolean authenticate(String username, String password) {
        return userDAO.checkCredentials(username, password);
    }
}
