package SpringRest.spring_rest.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import SpringRest.spring_rest.entity.Employee;
import SpringRest.spring_rest.service.EmployeeService;

/*
 * url: http://localhost:8080/spring-rest/api/employees
 * 
 * http://localhost:8080/spring-rest/api/employees/connectJpa
 */

@RestController
@RequestMapping(value="employees")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@PersistenceContext
	private EntityManager em;
	
	/*
	 * http://localhost:8080/spring-rest/api/employees/entityManagerJpa
	 */
	
	@Transactional
	@RequestMapping(method=RequestMethod.GET, value="entityManagerJpa")
	public List<Employee> entityManagerJPA(){
		
		TypedQuery<Employee> query = em.createNamedQuery("Employee.findAll", Employee.class);
		
		List<Employee> resultList = query.getResultList();
		
		resultList.forEach(result -> System.out.println(result));
		
		em.close();
		
		return resultList;
	}

	@RequestMapping(method=RequestMethod.GET)
	public List<Employee> findAll(){
		return service.findAll();
	}
	
	@RequestMapping(method=RequestMethod.GET, value="connectJpa")
	public Employee handleJPA(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
		
		EntityManager em = emf.createEntityManager();
		
		Employee emp = new Employee();
		emp.setName("test1");
		emp.setEmail("test1.app@mysql.com");
		emp.setSalary(88888888);
		
		em.getTransaction().begin();
		em.persist(emp);
		em.getTransaction().commit();
		
		emf.close();
		
		return emp;
	}
	
	/*
	 * http://localhost:8080/spring-rest/api/employees/selectJpa
	 */
	@RequestMapping(method=RequestMethod.GET, value="selectJpa")
	public List<Employee> updateJPA(){
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
		
		EntityManager em = emf.createEntityManager();
		
		TypedQuery<Employee> query = em.createQuery("select emp from Employee emp order by emp.id desc", Employee.class);
		
		List<Employee> resultList = query.getResultList();
		
		resultList.forEach(result -> System.out.println(result));
		
		query = em.createNamedQuery("Employee.findOne", Employee.class);
		query.setParameter("empId", "c70d95ed-8097-4c52-bd66-3f4ea621473c");
		
		Employee em1 = query.getSingleResult();
		System.out.println(em1);
		
		return resultList;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="{id}")
	public Employee findOne(@PathVariable("id") String empId) {
		Employee emp = new Employee("abc", "abc.a@gmail.com", new Integer(empId));
		return emp;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public Employee create(@RequestBody Employee employee) {
		
		return employee;
	}
	
	/*
	 * 
{
  "id": "c3e08a39-41d6-4990-bc79-81206ad8970f",
  "name": "abc",
  "email": "abc.a@gmail.com",
  "salary": 12000
}
	 */
	//provide Content-Type in Postman Client
	@RequestMapping(method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, value="{id}")
	public Employee update(@PathVariable("id") String empId, @RequestBody Employee employee) {
		employee.setSalary(new Integer(empId));
		return employee;
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="{id}")
	public void delete(@PathVariable("id") String empId) {
		
	}
}
