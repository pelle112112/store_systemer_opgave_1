package facade;


// Facade to interact with UserDAO
// Gets request from UserService layer
public class RepositoryFacade {


    public String fetchUserById(int id) {
        // Simulate fetching user from database
        return "User with ID: " + id;
    }


    public static RepositoryFacade getInstance() {
        return new RepositoryFacade();
    }
    public RepositoryFacade() {

    }


}
