package soft2;


import io.javalin.Javalin;
import io.javalin.apibuilder.EndpointGroup;

public class Routes {


    public EndpointGroup getRoutes(Javalin app){
        return () -> {
            app.routes(() -> {
                //path("/", ); TODO
                    });
        };
    }
}
