package SpringRest.spring_rest.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import SpringRest.spring_rest.entity.Employee;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository{

	@Override
	public List<Employee> findAll() {
		Employee emp = new Employee("abc", "abc.a@gmail.com", 12000);
		List<Employee> list = new ArrayList<Employee>();
		list.add(emp);
		return list;
	}

}
