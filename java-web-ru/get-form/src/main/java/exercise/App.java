package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import exercise.model.User;
import exercise.dto.users.UsersPage;
import java.util.Collections;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

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
                    String queryParam = ctx.queryParam("term");
                    UsersPage usersPage = new UsersPage(queryParam, new ArrayList<>());
                    for (User user: USERS) {
                        if (StringUtils.startsWithIgnoreCase(user.getFirstName(), queryParam)) {
                            usersPage.getUsers().add(user);

                        }
                    }
                    if (!usersPage.getUsers().isEmpty()) {
                        usersPage.getUsers().sort(User::compareTo);
                    }
                    ctx.render("index.jte", Collections.singletonMap("page", usersPage.getUsers().isEmpty()
                            ? new UsersPage(queryParam, USERS) : usersPage));
                }
        );
        // END

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
