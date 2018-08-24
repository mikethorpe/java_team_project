package controllers;

import db.DBHelper;
import models.Article;
import models.Author;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class ArticleController {


    public ArticleController(){
        setupEndPoints();
    }

    private static void setupEndPoints() {


        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        get("/articles/new", (req, res) -> {
                    Map<String, Object> model = new HashMap<>();
                    model.put("template", "templates/articles/new.vtl");
                    return new ModelAndView(model, "templates/layout.vtl");
                }, velocityTemplateEngine
        );

        get("/articles", (req, res) ->{
                    Map<String, Object> model = new HashMap<>();
                    List<Article> articles = DBHelper.findAll(Article.class);
                    model.put("template", "templates/articles/index.vtl");
                    model.put("articles", articles);
                    return new ModelAndView(model, "templates/layout.vtl");
                }, velocityTemplateEngine
        );

        post("/articles", (req, res) -> {
            String title = req.queryParams("title");
            String textContent = req.queryParams("text_content");
            Article article = new Article(title, textContent);
            DBHelper.save(article);
            res.redirect("/articles");
            return null;
        }, velocityTemplateEngine);


        post ("/articles/:id/delete", (req, res) -> {
            int id = Integer.parseInt(req.params(":id"));
            Article article = DBHelper.findById(Article.class, id);
            DBHelper.delete(article);
            res.redirect("/articles");
            return null;
        }, new VelocityTemplateEngine());
    }
}
