package exercise;

import io.javalin.Javalin;
import io.javalin.http.NotFoundResponse;

import java.util.List;
import java.util.Map;

// BEGIN

// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get(
                "/companies/{id}",
                ctx -> {
                    String id = ctx.pathParam("id");
                    System.out.println(COMPANIES.size());
                    if (isInteger(id)) {
                        if (Integer.parseInt(id) > 0 && Integer.parseInt(id) <= COMPANIES.size()) {
                            ctx.json(COMPANIES.stream()
                                    .parallel()
                                    .filter(i -> i.get("id").equals(id))
                                    .findFirst()
                                    .get()
                            );
                            return;
                        }
                    }
                    throw new NotFoundResponse("Company not found");
                }
        );
        // END

        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });

        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
