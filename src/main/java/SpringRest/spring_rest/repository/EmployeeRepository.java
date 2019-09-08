package SpringRest.spring_rest.repository;

import java.util.List;

import SpringRest.spring_rest.entity.Employee;

public interface EmployeeRepository {

	List<Employee> findAll();
}
