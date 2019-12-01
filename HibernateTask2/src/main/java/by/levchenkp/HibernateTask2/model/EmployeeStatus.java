package by.levchenkp.HibernateTask2.model;

public enum EmployeeStatus {
	VACANT("vacant"), BUSY("busy");
	private int id;
	private String name;

	EmployeeStatus(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
