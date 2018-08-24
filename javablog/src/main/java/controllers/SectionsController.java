package controllers;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;

import static spark.Spark.get;
public class SectionsController {

	public SectionsController() {
		setupEndPoints();
	}

	public static void setupEndPoints(){

		get("/sections/new", (req, res) -> {
			HashMap<String, Object> model = new HashMap<>();
			model.put("template", "templates/sections/new.vtl");

			return new ModelAndView(model, "templates/layout.vtl");
		}, new VelocityTemplateEngine());
	}
}
