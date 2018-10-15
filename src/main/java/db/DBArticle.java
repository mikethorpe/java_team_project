package db;

import models.Article;
import models.Author;
import models.Section;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
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
		List<Article> results = new ArrayList<>();

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

	public static List<Article> findAllArticlesInSection(Section section) {
		session = HibernateUtil.getSessionFactory().openSession();
		List<Article> results = null;
		try {
			Criteria cr = session.createCriteria(Article.class);
			cr.createAlias("sections", "section");
			cr.add(Restrictions.eq("section.id", section.getId()));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			cr.addOrder(Order.desc("lastUpdated"));
			results = cr.list();
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} finally {
			session.close();
		}
		return results;
	}



	public static List<Article> findAllArticlesInSectionOrderByViews(Section section, int numberOfResults){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Article> listOfArticles = new ArrayList<>();

		try {
			Criteria cr = session.createCriteria(Article.class);
			cr.createAlias("sections", "section");
			cr.add(Restrictions.eq("section.id", section.getId()));
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			cr.addOrder(Order.desc("numberOfViews"));
			cr.add(Restrictions.gt("numberOfViews",0));
			listOfArticles = cr.list();
		}
		catch (HibernateException ex){
			ex.printStackTrace();
		}
		finally {
			session.close();
		}

		// Ensure we don't try to get more articles back than exist in the query
		if (numberOfResults > listOfArticles.size()) {
			numberOfResults = listOfArticles.size();
		}
		List<Article> results = listOfArticles.subList(0, numberOfResults);
		return results;
	}



	public static List<Article> findAllArticlesOrderByViews(int numberOfResults){
		session = HibernateUtil.getSessionFactory().openSession();
		List<Article> listOfArticles = new ArrayList<>();

		try {
			Criteria cr = session.createCriteria(Article.class);
			cr.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			cr.addOrder(Order.desc("numberOfViews"));
			cr.add(Restrictions.gt("numberOfViews",0));
			listOfArticles = cr.list();
		}
		catch (HibernateException ex){
			ex.printStackTrace();
		}
		finally {
			session.close();
		}

		// Ensure we don't try to get more articles back than exist in the query
		if (numberOfResults > listOfArticles.size()) {
			numberOfResults = listOfArticles.size();
		}
		List<Article> results = listOfArticles.subList(0, numberOfResults);
		return results;
	}

}
