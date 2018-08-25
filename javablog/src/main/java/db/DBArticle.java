package db;

import models.Article;
import models.Section;

import java.util.List;

public class DBArticle {

	public static void updateArticlesSections(Article article, List<Section> sections){
		article.clearArticleSections();

		for(Section section : sections) {
			article.addSectionToArticle(section);
		}
		DBHelper.save(article);
	}
}
