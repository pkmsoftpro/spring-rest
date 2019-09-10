package SpringRest.spring_rest.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import SpringRest.spring_rest.entity.Employee;
import SpringRest.spring_rest.service.EmployeeService;

/*
 * url: http://localhost:8080/spring-rest/api/employees
 * 
 * http://localhost:8080/spring-rest/api/employees/connectJpa
 * 
 * Hibernate: select employee0_.id as id1_0_, employee0_.email as email2_0_, employee0_.name as name3_0_, employee0_.salary as salary4_0_ from employee employee0_
 * 
 * in SpringBoot, the query with small case entity are getting called, so even if the entity is Employee then query will be ran for employee. @see above
 * 
 * url: http://localhost:8080/employees/springEntityManagerJpa
 */

@RestController
@RequestMapping(value="employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	/*
	 * http://localhost:8080/employees/springEntityManagerJpa
	 */
	
	@Transactional
	@RequestMapping(method=RequestMethod.GET, value="springEntityManagerJpa")
	public List<Employee> entityManagerJPA(){
		
		List<Employee> resultList = service.findAll();
		
		return resultList;
	}

}
