package soft2.user.repositoryFacade;

import soft2.user.repository.UserDAO;

public class RepositoryFacade {

    private final UserDAO userDAO;

    public RepositoryFacade() {
        this.userDAO = new UserDAO();
    }

    public boolean authenticate(String username, String password) {
        return userDAO.checkCredentials(username, password);
    }
}