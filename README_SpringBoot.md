

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
