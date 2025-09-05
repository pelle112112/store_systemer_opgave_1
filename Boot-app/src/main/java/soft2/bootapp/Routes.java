package soft2.bootapp;

import io.javalin.Javalin;
import io.javalin.apibuilder.EndpointGroup;

import static io.javalin.apibuilder.ApiBuilder.*;

import soft2.user.userFacade.AppFacade;

public class Routes {

    private final AppFacade userFacade = new AppFacade();

    public EndpointGroup getRoutes(Javalin app){
        return () -> app.routes(() -> {

            get("/user", ctx -> ctx.redirect(ctx.contextPath() + "/user/index.html"));

            // POST /api/user/login  -> calls AppFacade.login(username, password)
            path("/user", () -> {
                post("/login", ctx -> {
                    Cred body = ctx.bodyAsClass(Cred.class); // parsed by Jackson
                    boolean ok = userFacade.login(body.username, body.password);

                    if (ok) {
                        ctx.status(200).json(new ApiResponse(true, "Login successful"));
                    } else {
                        ctx.status(401).json(new ApiResponse(false, "Invalid username or password"));
                    }
                });
            });
        });
    }

    // Simple request/response types local to Boot-app:
    static final class Cred { public String username; public String password; }
    static final class ApiResponse {
        public final boolean success; public final String message;
        ApiResponse(boolean success, String message) { this.success = success; this.message = message; }
    }
}
