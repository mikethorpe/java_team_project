package db;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.omg.CORBA.PUBLIC_MEMBER;

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


}
