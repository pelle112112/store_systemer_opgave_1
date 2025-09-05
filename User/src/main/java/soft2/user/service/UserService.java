package soft2.user.service;

import soft2.user.repositoryFacade.RepositoryFacade;


public class UserService {

    private final RepositoryFacade repoFacade;

    public UserService() {
        this.repoFacade = new RepositoryFacade();
    }

    public boolean authenticate(String username, String password) {
        return repoFacade.authenticate(username, password);
    }
}
