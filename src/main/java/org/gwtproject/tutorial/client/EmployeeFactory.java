package org.gwtproject.tutorial.client;

import org.gwtproject.tutorial.server.Employee;

import com.google.web.bindery.requestfactory.shared.InstanceRequest;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.RequestFactory;
import com.google.web.bindery.requestfactory.shared.Service;

public interface EmployeeFactory extends RequestFactory {
	
	EmployeeRequest createEmployeeRequest();
	
	@Service(value = Employee.class)
	public interface EmployeeRequest extends RequestContext {
		Request<EmployeeProxy> findEmployee(Long id);
		
		InstanceRequest<EmployeeProxy, Void> persist();
		InstanceRequest<EmployeeProxy, Void> remove();
	}
}
