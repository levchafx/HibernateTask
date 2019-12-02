package by.levchenkp.HibernateTask2.dao;

import java.util.List;

import javax.persistence.EntityManager;

import by.levchenkp.HibernateTask2.model.Employee;
import by.levchenkp.HibernateTask2.model.Project;

public class ProjectDao extends AbstractCrudDao<Project> {

	@Override
	protected String getSqlForGetAll() {

		return "select * from Project ";
	}

	@Override
	Class<Project> getTClass() {

		return Project.class;
	}

	public List<Employee> getEmployees(int id) {

		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		List<Employee> employees = em.createQuery("select e from Employee e join e.projects p on p.id=:id ")
				.setParameter("id", id).getResultList();
		em.getTransaction().commit();
		em.close();
		return employees;
	}

	public List<Project> getProjectsWithEmployeesNotExternal() {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		List<Project> projects = em.createQuery("select p from Project p  join p.employees e on e.external='false'")
				.getResultList();
		em.getTransaction().commit();
		em.close();
		return projects;
	}

}
