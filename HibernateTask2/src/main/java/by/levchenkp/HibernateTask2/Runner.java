package by.levchenkp.HibernateTask2;

import java.util.HashSet;
import java.util.Set;

import by.levchenkp.HibernateTask2.dao.EmployeeDao;
import by.levchenkp.HibernateTask2.dao.ProjectDao;
import by.levchenkp.HibernateTask2.dao.UnitDao;
import by.levchenkp.HibernateTask2.model.Address;
import by.levchenkp.HibernateTask2.model.Employee;
import by.levchenkp.HibernateTask2.model.EmployeePersonalInfo;
import by.levchenkp.HibernateTask2.model.EmployeeStatus;
import by.levchenkp.HibernateTask2.model.Project;
import by.levchenkp.HibernateTask2.model.Unit;

public class Runner {
	public static void main(String[] args) {
		EmployeeDao employeeDao = new EmployeeDao();
		ProjectDao projectDao = new ProjectDao();
		UnitDao unitDao = new UnitDao();
		Set<Project> projects = new HashSet<Project>();
		Employee e = new Employee();
		Address a = new Address();
		a.setAddress("gomel,tsarikov street");

		EmployeePersonalInfo i = new EmployeePersonalInfo();
		i.setAge(35);
		i.setName("sergei");
		e.setExternal(true);

		e.setAddress(a);

		e.setInfo(i);
		e.setStatus(EmployeeStatus.VACANT);
		Project p = new Project();
		p.setPName("LoginApp");
		// projectDao.create(p);
		// employeeDao.create(e);
		Unit u = new Unit();
		u.setUName("Java");
		// unitDao.create(u);
		// Employee e1 = employeeDao.findById(1);
		// employeeDao.delete(2);
		Project pr = new Project();
		pr.setPName("Library");
		// projectDao.create(pr);
		// employeeDao.assignToUnit(5, 4);
		employeeDao.assignToProject(3, 4);
		for (Employee emp : employeeDao.getAll()) {
			System.out.println(emp + " " + employeeDao.getProjects(emp.getId()));
		}
		System.out.println(projectDao.getProjectsWithEmployeesNotExternal());
	}
}