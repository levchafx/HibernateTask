package by.levchenkp.HibernateTask2.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;

import by.levchenkp.HibernateTask2.model.Employee;
import by.levchenkp.HibernateTask2.model.Project;

public class EmployeeDao extends AbstractCrudDao<Employee> {

	@Override
	protected String getSqlForGetAll() {

		return "select * from Employee ";
	}

	@Override
	protected Class<Employee> getTClazz() {

		return Employee.class;
	}

	public Set<Project> getProjects(int id) {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		Set<Project> projects = new HashSet(em.createQuery("select p from Project p join p.employees e on e.id=:id")
				.setParameter("id", id).getResultList());
		em.getTransaction().commit();
		em.close();
		return projects;
	}

	public void assignToUnit(int employee_id, int unit_id) {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("update  employee set unit_id=:unit_id where id=:employee_id ")
				.setParameter("unit_id", unit_id).setParameter("employee_id", employee_id).executeUpdate();
		em.getTransaction().commit();
		em.close();
	}

	public void assignToProject(int employee_id, int project_id) {
		EntityManager em = HibernateUtil.getEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("insert into employee_project (employee_id,project_id) values(:employee_id,:project_id)")
				.setParameter("employee_id", employee_id).setParameter("project_id", project_id).executeUpdate();
		em.getTransaction().commit();
		em.close();
	}

}
