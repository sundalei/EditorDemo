package org.gwtproject.tutorial.server;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class EmployeeEntityManager {

	static ConcurrentHashMap<Long, Employee> entities = new ConcurrentHashMap<Long, Employee>();
	static AtomicLong index = new AtomicLong();

	public static Employee persist(Employee entity) {
		System.out.println(Thread.currentThread().getName());
		if (entity.getId() == null) {
			entity.setId(index.incrementAndGet());
			entity.setVersion(1);
		} else {
			Employee fetched = fetch(entity.getId());
			entity.setVersion(fetched.getVersion() + 1);
		}
		entities.put(entity.getId(), entity);
		return entity;
	}

	public static List<Employee> list() {
		ArrayList<Employee> result = new ArrayList<Employee>();
		for (Employee e : entities.values()) {
			result.add(e);
		}
		return result;
	}

	public static Employee fetch(Long id) {
		Employee employee = entities.get(id);
		if (employee == null) {
			return null;
		}
		return employee;
	}
}
