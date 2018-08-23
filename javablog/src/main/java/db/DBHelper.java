package db;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DBHelper {

	private static Session session;
	private static Transaction transaction;

	public static void save(Object object){
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			transaction = session.beginTransaction();
			session.saveOrUpdate(object);
			transaction.commit();
		}
		catch (HibernateException ex){
			transaction.rollback();;
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	public static void delete(Object object){
		session = HibernateUtil.getSessionFactory().openSession();

		try {
			transaction = session.beginTransaction();
			session.delete(object);
			transaction.commit();
		}
		catch (HibernateException ex){
			transaction.rollback();
			ex.printStackTrace();
		}
		finally {
			session.close();
		}
	}

	public static <T> List<T> findAll(Class classType){
		session = HibernateUtil.getSessionFactory().openSession();
		List<T> results = null;

		try {
			Criteria cr = session.createCriteria(classType);
			results = cr.list();
			System.out.println("hello");
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
