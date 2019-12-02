package by.levchenkp.HibernateTask2.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public abstract class AbstractCrudDao<T> {
	protected abstract String getSqlForGetAll();

	abstract Class<T> getTClass();

	public void create(T t) {

		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
	}

	public List<T> getAll() {
		List<T> tees;
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		tees = em.createNativeQuery(getSqlForGetAll(), getTClass()).getResultList();
		em.getTransaction().commit();
		em.close();
		return tees;
	}

	public void update(T t) {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();

		em.merge(t);

		em.getTransaction().commit();
		em.close();
	}

	@Transactional
	public void delete(int id) {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		T t = em.find(getTClass(), id);
		em.remove(t);

		em.getTransaction().commit();
		em.close();
	}

	public T findById(int id) {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		T t = em.find(getTClass(), id);
		em.getTransaction().commit();
		em.close();
		return t;
	}
}
