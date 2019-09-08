package SpringRest.spring_rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import SpringRest.spring_rest.entity.Employee;
import SpringRest.spring_rest.exception.EmployeeNotFoundExcpetion;
import SpringRest.spring_rest.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	EmployeeRepository repository;

	@Override
	public List<Employee> findAll() {
		return repository.findAll();
		//throw new EmployeeNotFoundExcpetion("Employee found");
	}

}
