package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.javalin.Javalin;

import java.util.List;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        Javalin app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        app.get(
                "/phones",

                ctx -> {
                    String json = toJson(Data.getPhones());
                    ctx.contentType("application/json");
                    ctx.result(json);
                }
        );

        app.get(
                "/domains",
                ctx -> ctx.json(Data.getDomains())
        );
        // END
        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }

    public static String toJson(List<String> list) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(list);
    }
}
