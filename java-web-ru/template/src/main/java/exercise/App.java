package exercise;

import io.javalin.Javalin;

import java.util.List;

import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;

import java.util.Collections;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get(
                "/users",
                ctx -> {
                    UsersPage page = new UsersPage(USERS, "Информация обо всех пользователях.");
                    ctx.render("users/index.jte", Collections.singletonMap("page", page));
                }
        );

        app.get(
                "/users/{id}",
                ctx -> {
                    String id = ctx.pathParam("id");
                    User user = USERS.stream()
                            .parallel()
                            .filter(i -> Long.toString((i.getId())).equals(id))
                            .findFirst()
                            .orElse(null);
                    if (user == null) {
                        throw new NotFoundResponse("User not found");
                    }
                    UserPage page = new UserPage(user, "Информация о пользователе " + user.getFirstName());
                    ctx.render("users/show.jte", Collections.singletonMap("page", page));
                }
        );

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
