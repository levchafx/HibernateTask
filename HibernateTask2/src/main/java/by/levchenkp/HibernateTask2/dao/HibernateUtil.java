package by.levchenkp.HibernateTask2.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
	private static final EntityManagerFactory emf;
	static {
		emf = Persistence.createEntityManagerFactory("PERSISTENCE");
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	public static void close() {
		emf.close();
	}
}
