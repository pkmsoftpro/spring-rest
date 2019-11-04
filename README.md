

For the Persistence layer:

1. Create a file persistence.xml in src/main/resource folder:

<persistence xmlns="http://java.sun.com/xml/ns/persistence"
             xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
             xsi:schemaLocation="http://java.sun.com/xml/ns/persistence http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd"
             version="2.0">
   <persistence-unit name="sample">
      <provider>org.hibernate.jpa.HibernatePersistenceProvider</provider>
      <properties>
      	 <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"/>
      	 <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/emp_db?useUnicode=true&amp;useJDBCCompliantTimezoneShift=true&amp;useLegacyDatetimeCode=false&amp;serverTimezone=UTC"/>
      	 <property name="javax.persistence.jdbc.user" value="root"/>
         <property name="javax.persistence.jdbc.password" value="Root123!"/>
         <property name="hibernate.hbm2ddl.auto" value="update"/>
         <property name="hibernate.show_sql" value="true"/>
      </properties>
   </persistence-unit>
</persistence>

2. For the Java Code:

imports:
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
	
	
3. Entity:

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
	@NamedQuery(name = "Employee.findAll", query = "select emp from Employee emp order by emp.id desc"),
	@NamedQuery(name = "Employee.findOne", query = "select emp from Employee emp where emp.id=:empId")
})
public class Employee {
	
	@Id
	@Column(columnDefinition = "VARCHAR(40)")
	private String id;
	private String name;
	private String email;
	private int salary;
	
	
	
	public Employee() {
		this.id = UUID.randomUUID().toString();
	}

	public Employee(String name, String email, int salary) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.email = email;
		this.salary = salary;
	}
	
4. pom.xml:

		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.4.3.Final</version>
		</dependency>

		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.15</version>
		</dependency>
		
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
			<version>5.1.9.RELEASE</version>
		</dependency>

