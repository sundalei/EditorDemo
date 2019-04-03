package org.gwtproject.tutorial.server;

import java.util.concurrent.atomic.AtomicLong;

public class Employee {
	
	private Long id;
	private Integer version;
	private String name;
	private String title;
	
	static AtomicLong index = new AtomicLong();
	
	public static Employee findEmployee(Long id) {
		Employee employee = new Employee();
		employee.setId(1L);
		employee.setName("test");
		employee.setTitle("name");
		return employee;
	}
	
	public Employee persist() {
		
		Employee result = EmployeeEntityManager.persist(this);
		System.out.println(EmployeeEntityManager.list());
		return result;
	}
	
	public void remove() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", version=" + version + ", name=" + name + ", title=" + title + "]";
	}
}
