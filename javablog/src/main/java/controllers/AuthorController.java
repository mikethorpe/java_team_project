package controllers;

import db.DBHelper;
import models.Author;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class AuthorController {

	public AuthorController(){
		setupEndPoints();
	}

	private static void setupEndPoints(){

		VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

		get("/authors/new", (req, res) ->{
			Map<String, Object> model = new HashMap<>();
			model.put("template", "templates/authors/new.vtl");
			return new ModelAndView(model, "templates/layout.vtl");
		}, velocityTemplateEngine
		);

		post("/authors", (req, res) -> {
			String name = req.queryParams("name");
			Author author = new Author(name);
			DBHelper.save(author);
			res.redirect("/authors");
			return null;
		}, velocityTemplateEngine
		);
	}
}
