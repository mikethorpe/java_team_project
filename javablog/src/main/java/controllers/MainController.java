package controllers;

import db.DBHelper;
import models.Article;
import models.Author;

public class MainController {

	public static void main(String[] args) {

		// Seeds
		Author author = new Author("Molly");
		DBHelper.save(author);
		Article article = new Article("Mike and molly write code", "Some content");
		DBHelper.save(article);

		// Controllers
		AuthorController authorController = new AuthorController();
		ArticleController articleController = new ArticleController();
		SectionsController sectionsController = new SectionsController();
	}
}
