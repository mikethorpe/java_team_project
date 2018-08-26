package controllers;

import db.DBHelper;
import models.Article;
import models.Author;
import models.Section;

public class MainController {

	public static void main(String[] args) {

		//setup
		setupEndPoints();

		// Controllers
		AuthorController authorController = new AuthorController();
		ArticleController articleController = new ArticleController();
		SectionsController sectionsController = new SectionsController();
	}

	private static void	setupEndPoints(){
		// Seeds
		Author author1 = new Author("Mike");
		DBHelper.save(author1);

		Author author2 = new Author("Molly");
		DBHelper.save(author2);

		Article article1 = new Article("Article1 title", "Article 1 content", author1);
		DBHelper.save(article1);

		Article article2 = new Article("Article2 title", "Article 2 content", author2);
		DBHelper.save(article2);

		Article article3 = new Article("Article3 title", "Article 3 content", author2);
		DBHelper.save(article3);


		Section section1 = new Section("Technology");
		DBHelper.save(section1);

		Section section2 = new Section("Art");
		DBHelper.save(section2);

		Section section3 = new Section("Environment");
		DBHelper.save(section3);
	}

}

