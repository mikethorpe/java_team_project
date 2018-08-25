package db;

import models.Article;
import models.Section;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBArticle {

	private static Session session;
	private static Transaction transaction;

	public static void addArticleToSection(Article article, Section section){
		section.addArticleToSection(article);
		DBHelper.save(section);
	}
}
