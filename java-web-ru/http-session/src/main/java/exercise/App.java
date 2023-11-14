package exercise;

import io.javalin.Javalin;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get(
                "/users",
                App::getResult
        );
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }

    private static void getResult(@NotNull Context ctx) {
        String pages = ctx.queryParam("page");
        String pers = ctx.queryParam("per");
        if (pages != null && pers != null) {
            Integer count = Integer.parseInt(pages) * Integer.parseInt(pers);
            ctx.json(USERS.subList(count - Integer.parseInt(pers), count));
        } else {
            ctx.json(USERS.subList(0, 5));
        }
    }
}
