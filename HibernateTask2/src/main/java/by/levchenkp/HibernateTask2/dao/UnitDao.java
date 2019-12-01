package by.levchenkp.HibernateTask2.dao;

import by.levchenkp.HibernateTask2.model.Unit;

public class UnitDao extends AbstractCrudDao<Unit> {

	@Override
	protected String getSqlForGetAll() {

		return "select*from unit";
	}

	@Override
	Class<Unit> getTClass() {

		return Unit.class;
	}

}
