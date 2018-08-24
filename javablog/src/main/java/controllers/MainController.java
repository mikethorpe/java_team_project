package controllers;

import db.DBHelper;
import models.Author;

public class MainController {

	public static void main(String[] args) {

		Author author = new Author("Molly");
		DBHelper.save(author);
		AuthorController authorController = new AuthorController();
		ArticleController articleController = new ArticleController();
	}
}
