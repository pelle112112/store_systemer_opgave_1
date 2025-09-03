package service;

import facade.RepositoryFacade;

public class UserService {

    // Singleton Service layer

    private static UserService instance;
    private UserService() {}
    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    // Talks to RepositoryFacade layer

    RepositoryFacade repositoryFacade = RepositoryFacade.getInstance();
    public String getUserById(int id) {
        return repositoryFacade.fetchUserById(id);
    }



}
