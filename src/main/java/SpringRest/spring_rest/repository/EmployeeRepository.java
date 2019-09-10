package SpringRest.spring_rest.repository;

import org.springframework.data.repository.CrudRepository;

import SpringRest.spring_rest.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, String>{

}
