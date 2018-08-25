import db.DBArticle;
import db.DBHelper;
import models.Article;
import models.Author;
import models.Section;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Author author1 = new Author("Mike");
        DBHelper.save(author1);
        Author author2 = new Author("Molly");
        DBHelper.save(author2);

        Article article = new Article("Mike and molly code", "Amazing coding story", author1);
        DBHelper.save(article);

		Section section = new Section("Technology");
		DBHelper.save(section);

		DBArticle.addArticleToSection(article, section);

		Article foundArticle = DBHelper.findById(Article.class, 1);
		Section foundSection = DBHelper.findById(Section.class, 1);
    }
}
