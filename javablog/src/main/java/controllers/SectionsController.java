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
			return new ModelAndView(model, "templates/backend_layout.vtl");

		}, new VelocityTemplateEngine());

		get("/sections/new", (req, res) -> {
			Map<String, Object> model = new HashMap<>();
			model.put("template", "templates/sections/new.vtl");
			return new ModelAndView(model, "templates/backend_layout.vtl");
		}, new VelocityTemplateEngine());

		post("/sections", (req, res) -> {
			String title = req.queryParams("title");
			Section section = new Section(title);
			DBHelper.save(section);
			res.redirect("/sections");
			return null;
		}, new VelocityTemplateEngine());

		post("/sections/:id/delete", (req, res) -> {
			int sectionId = Integer.parseInt(req.params(":id"));
			Section section = DBHelper.findById(Section.class, sectionId);
			DBHelper.delete(section);
			res.redirect("/sections");
			return null;
		}, new VelocityTemplateEngine());

		get("/sections/:id/edit", (req,res) ->{
			Map<String, Object> model = new HashMap<>();
			model.put("template", "templates/sections/edit.vtl");
			int sectionId = Integer.parseInt(req.params(":id"));
 			Section section = DBHelper.findById(Section.class, sectionId);
			model.put("section", section);
			return new ModelAndView(model, "templates/backend_layout.vtl");
		}, new VelocityTemplateEngine());

		post("/sections/:id/edit", (req, res) -> {
			int sectionId = Integer.parseInt(req.params(":id"));
			String title = req.queryParams("title");
			Section section = DBHelper.findById(Section.class, sectionId);
			section.setTitle(title);
			DBHelper.save(section);
			res.redirect("/sections");
			return null;
		}, new VelocityTemplateEngine());

	}
}
