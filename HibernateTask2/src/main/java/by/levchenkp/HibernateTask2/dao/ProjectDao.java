package by.levchenkp.HibernateTask2.dao;

import java.util.HashSet;
import java.util.Set;

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

	public Set<Employee> getEmployees(int id) {

		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		Set<Employee> employees = new HashSet<Employee>(
				em.createQuery("select e from Employee e join e.projects p on p.id=:id ").setParameter("id", id)
						.getResultList());
		em.getTransaction().commit();
		em.close();
		return employees;
	}

	public Set<Project> getProjectsWithEmployeesNotExternal() {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		Set<Project> projects = (Set<Project>) em
				.createQuery("select p from Project p  join p.employees e on e.external='false'").getResultList();
		em.getTransaction().commit();
		em.close();
		return projects;
	}

	@Override
	public void delete(int id) {

		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("delete from employee_project where project_id=:id").setParameter("id", id)
				.executeUpdate();
		em.getTransaction().commit();
		em.close();
		super.delete(id);
	}

}
