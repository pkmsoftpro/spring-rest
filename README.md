

For the Spring Boot Configuration:

1. pom.xml
	<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
			<version>2.1.8.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
			<version>2.1.8.RELEASE</version>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.15</version>
		</dependency>
		
2. @EnableAutoConfiguration--> it looks into class path and check if it has web-starter and data-jpa then it will 	automatically configure JPA and Application for enabling spring and jpa configuration for the project

3. It will auto-configure spring application so get rid of AppInitializer and JPAConfig

4. use Spring-data, remove EmployeeRepositoryImpl.java

```
 * Hibernate: select employee0_.id as id1_0_, employee0_.email as email2_0_, employee0_.name as name3_0_, employee0_.salary as salary4_0_ from employee employee0_
 * 
 * in SpringBoot, the query with small case entity are getting called, so even if the entity is Employee then query will be ran for employee. @see above
 * 
 * url: http://localhost:8080/employees/springEntityManagerJpa
```
