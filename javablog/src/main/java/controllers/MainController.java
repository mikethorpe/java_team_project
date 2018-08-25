package controllers;

import db.DBHelper;
import models.Article;
import models.Author;
import models.Section;

public class MainController {

	public static void main(String[] args) {

		// Seeds
		Author author = new Author("Molly");
		DBHelper.save(author);
		Article article = new Article("Mike and molly write code", "Some content", author);
		DBHelper.save(article);
		Section section1 = new Section("Technology");
		DBHelper.save(section1);
		Section section2 = new Section("Environment");
		DBHelper.save(section2);
		Section section3 = new Section("Art");
		DBHelper.save(section3);

		// Controllers
		AuthorController authorController = new AuthorController();
		ArticleController articleController = new ArticleController();
		SectionsController sectionsController = new SectionsController();
	}
}
