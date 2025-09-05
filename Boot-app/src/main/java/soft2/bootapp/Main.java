package soft2.bootapp;

import io.javalin.Javalin;

public class Main {
    public static void main(String[] args) {
        Javalin app = Javalin.create();
        ServerConfig.startJavalinServer(app, 7070);
        System.out.println("Boot-app on http://localhost:7070/api/");
    }
}