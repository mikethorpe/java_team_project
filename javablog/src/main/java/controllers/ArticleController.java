package controllers;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;

public class ArticleController {

    private static void setupEndPoints() {

        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/articles/new", (req, res) -> {
                    Map<String, Object> model = new HashMap<>();
                    model.put("template", "templates/articles/new.vtl");
                    return new ModelAndView(model, "templates/layout.vtl");
                }, velocityTemplateEngine
        );
    }
}
