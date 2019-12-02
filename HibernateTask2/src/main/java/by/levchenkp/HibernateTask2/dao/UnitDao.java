package by.levchenkp.HibernateTask2.dao;

import by.levchenkp.HibernateTask2.model.Employee;
import by.levchenkp.HibernateTask2.model.Unit;

public class UnitDao extends AbstractCrudDao<Unit> {

	@Override
	protected String getSqlForGetAll() {

		return "select * from unit ";
	}

	@Override
	Class<Unit> getTClass() {

		return Unit.class;
	}

	@Override
	public void delete(int id) {
		EmployeeDao employeeDao = new EmployeeDao();
		Unit u = findById(id);
		for (Employee e : u.getEmployees()) {
			e.setUnit(null);
			employeeDao.update(e);
		}
		update(u);
		super.delete(id);
	}

}
