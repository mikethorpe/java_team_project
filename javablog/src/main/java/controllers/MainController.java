package controllers;

import db.DBHelper;
import models.Article;
import models.Author;

public class MainController {

	public static void main(String[] args) {

		Author author = new Author("Molly");
		DBHelper.save(author);
		Article article = new Article("Mike and molly write code", "Some content");
		DBHelper.save(article);
		AuthorController authorController = new AuthorController();
		ArticleController articleController = new ArticleController();
	}
}
