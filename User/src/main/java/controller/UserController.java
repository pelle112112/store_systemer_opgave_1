package controller;
import io.javalin.http.Handler;
import service.UserService;


// Controller talks to Service layer
public class UserController {
    UserService userService = UserService.getInstance();


    public Handler getUserHandler (){
        return ctx -> {
            ctx.status(200);
            ctx.json()
        };
    }


}
