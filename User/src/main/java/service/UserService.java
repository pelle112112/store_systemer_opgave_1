package service;

import facade.RepositoryFacade;


public class UserService {

    private final RepositoryFacade repoFacade;

    public UserService() {
        this.repoFacade = new RepositoryFacade();
    }

    public boolean authenticate(String username, String password) {
        return repoFacade.authenticate(username, password);
    }
}
