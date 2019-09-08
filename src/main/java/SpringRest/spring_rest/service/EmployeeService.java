package SpringRest.spring_rest.service;

import java.util.List;

import SpringRest.spring_rest.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();
}
