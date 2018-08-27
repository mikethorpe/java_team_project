import db.DBArticle;
import db.DBHelper;
import models.Article;
import models.Author;
import models.Section;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Author author1 = new Author("Mike");
        DBHelper.save(author1);

        Author author2 = new Author("Molly");
        DBHelper.save(author2);

        Article article1 = new Article("Article1 title", "Article 1 content", author1);
        article1.updateArticleDate();
        DBHelper.save(article1);

		Article article2 = new Article("Article2 title", "Article 2 content", author2);
		article2.updateArticleDate();
		DBHelper.save(article2);

		Article article3 = new Article("Article3 title", "Article 3 content", author2);
		article3.updateArticleDate();
		DBHelper.save(article3);

		article1.addView();
		DBHelper.save(article1);

		Article articleWithView = DBHelper.findById(Article.class, article1.getId());

		Section section1 = new Section("Technology");
		DBHelper.save(section1);

		Section section2 = new Section("Art");
		DBHelper.save(section2);

		Section section3 = new Section("Environment");
		DBHelper.save(section1);


		List<Section> sections = new ArrayList<>();
		sections.add(section1);

		DBArticle.updateArticlesSections(article1, sections);

		Article foundArticle = DBHelper.findById(Article.class, 1);
		Section foundSection = DBHelper.findById(Section.class, 1);

		List<Article> mollysArticles = DBArticle.findAllAuthorsArticles(author2);
    }
}
