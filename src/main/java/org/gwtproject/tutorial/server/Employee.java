package org.gwtproject.tutorial.server;

public class Employee {
	
	private Long id;
	private Integer version;
	private String name;
	private String title;
	
	public static Employee findEmployee(Long id) {
		return null;
	}
	
	public void persist(Employee e) {
		
	}
	
	public void remove(Employee e) {
		
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
}
