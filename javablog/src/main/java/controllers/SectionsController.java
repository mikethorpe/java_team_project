package controllers;

import db.DBHelper;
import models.Section;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.get;
import static spark.Spark.post;

public class SectionsController {

	public SectionsController() {
		setupEndPoints();
	}

	public static void setupEndPoints(){

		get("/sections", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			model.put("template", "/templates/sections/index.vtl");
			List<Section> sections = DBHelper.findAll(Section.class);
			model.put("sections", sections);
			return new ModelAndView(model, "templates/layout.vtl");

		}, new VelocityTemplateEngine());

		get("/sections/new", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			model.put("template", "templates/sections/new.vtl");
			return new ModelAndView(model, "templates/layout.vtl");
		}, new VelocityTemplateEngine());

		post("/sections", (req, res) -> {
			String title = req.queryParams("title");
			Section section = new Section(title);
			DBHelper.save(section);
			res.redirect("/sections");
			return null;
		}, new VelocityTemplateEngine());
	}
}
