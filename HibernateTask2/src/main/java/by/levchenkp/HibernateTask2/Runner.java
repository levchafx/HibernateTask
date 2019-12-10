package by.levchenkp.HibernateTask2;

import java.util.List;

import by.levchenkp.HibernateTask2.dao.EmployeeDao;
import by.levchenkp.HibernateTask2.model.Address;
import by.levchenkp.HibernateTask2.model.Employee;
import by.levchenkp.HibernateTask2.model.EmployeePersonalInfo;
import by.levchenkp.HibernateTask2.model.EmployeeStatus;

public class Runner {
	private static EmployeeDao employeeDao = new EmployeeDao();

	private static Employee createEmployee() {
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
		return employeeDao.create(e);
	}

	private static void deleteEmployee() {
		employeeDao.delete(1);

	}

	private static Employee updateEmployee() {
		Employee e = employeeDao.findById(1);
		e.setAddress(new Address(" minsk,prospekt pobeditelei"));
		e.getInfo().setName("someName");
		e.getInfo().setAge(155);
		return employeeDao.update(e);

	}

	private static List<Employee> getAllEmployees() {
		return employeeDao.getAll();
	}

	public static void main(String[] args) {

	}
}