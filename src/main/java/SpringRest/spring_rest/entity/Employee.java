package SpringRest.spring_rest.entity;

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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", salary=" + salary + "]";
	}

}
