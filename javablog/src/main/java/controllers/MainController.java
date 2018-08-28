package controllers;

import db.DBArticle;
import db.DBHelper;
import models.Article;
import models.Author;
import models.Section;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.get;
import static spark.SparkBase.staticFileLocation;

public class MainController {

	public static void main(String[] args) {

        //location of static files - .css, images, etc
        staticFileLocation("/public");

		//setup
		setupEndPoints();

		// Controllers
		AuthorController authorController = new AuthorController();
		ArticleController articleController = new ArticleController();
		SectionsController sectionsController = new SectionsController();
	}



	private static void	setupEndPoints(){

		//Redirects to main section on frontend
		get("/", (req, res) -> {
			res.redirect("/sections/1");
			return null;
			}, new VelocityTemplateEngine()
		);

		//Redirects to articles on backend section
		get("/admin", (req, res) -> {
					res.redirect("/articles");
					return null;
				}, new VelocityTemplateEngine()
		);

		// Seeds
		// Set up sections
		Section section1 = new Section("Home");
		DBHelper.save(section1);

		Section section2 = new Section("Art");
		DBHelper.save(section2);

		Section section3 = new Section("Environment");
		DBHelper.save(section1);


		List<Section> home = new ArrayList<>();
		home.add(section1);

		List<Section> artSections = new ArrayList<>();
		artSections.add(section2);

		// Set up authors
		Author author1 = new Author("Mike");
		DBHelper.save(author1);

		Author author2 = new Author("Molly");
		DBHelper.save(author2);

		// Set up sections

		Article article2 = new Article("Article2 title", "Article 2 content", author2);
		article2.addView();
		article2.addView();
		article2.updateArticleDate();
		DBHelper.save(article2);

		Article article3 = new Article("Article3 title", "Article 3 content", author2);
		article3.addView();
		article3.updateArticleDate();
		DBHelper.save(article3);

		Article article1 = new Article("Article1 title", "Article 1 content", author1);
		article1.updateArticleDate();
		article1.addView();
		article1.addView();
		article1.addView();
		DBHelper.save(article1);


		DBArticle.updateArticlesSections(article1, home);
		DBArticle.updateArticlesSections(article2, home);
		DBArticle.updateArticlesSections(article3, artSections);
	}

}

