package db;

import models.Article;
import models.Author;
import models.Section;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBArticle {
	private static Session session;

	public static void updateArticlesSections(Article article, List<Section> sections){
		article.clearArticleSections();

		for(Section section : sections) {
			article.addSectionToArticle(section);
		}
		DBHelper.save(article);
	}

	public static List<Article> findAllAuthorsArticles(Author author){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Article> results = null;

		try {
			Criteria cr = session.createCriteria(Article.class);
			cr.add(Restrictions.eq("author", author));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			cr.addOrder(Order.asc("id"));
			results = cr.list();
		}
		catch (HibernateException ex){
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
		return results;
	}

}
