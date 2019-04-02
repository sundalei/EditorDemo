package org.gwtproject.tutorial.client;

import org.gwtproject.tutorial.server.Employee;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value = Employee.class)
public interface EmployeeProxy extends EntityProxy {

	Long getId();

	void setId(Long id);

	String getName();

	void setName(String name);

	String getTitle();

	void setTitle(String title);
}
