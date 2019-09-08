

For the Persistence layer:

1. create the class JPAConfig.java
		a. in url, change &amp; to &
		b. add emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		c. add jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		
2. For @Transactional
		add the following in JPAConfig.java
			a. @Bean
				public PlatformTransactionManager txManager(EntityManagerFactory emf) {
					JpaTransactionManager txm = new JpaTransactionManager(emf);
					return txm;
				}
			b. @EnableTransactionManagement
		
		
2. In AppInitializer.java add JPAConfig.class
	
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {Application.class, JPAConfig.class};
	}

3. In pom.xml
	add:
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-orm</artifactId>
			<version>5.1.9.RELEASE</version>
		</dependency>

4. for Java code in Controller:
	@PersistenceContext
	private EntityManager em;
	
	/*
	 * http://localhost:8080/spring-rest/api/employees/entityManagerJpa
	 */
	
	@RequestMapping(method=RequestMethod.GET, value="entityManagerJpa")
	public List<Employee> entityManagerJPA(){
		
		TypedQuery<Employee> query = em.createNamedQuery("Employee.findAll", Employee.class);
		
		List<Employee> resultList = query.getResultList();
		
		resultList.forEach(result -> System.out.println(result));
		
		em.close();
		
		return resultList;
	}
	
5. persistence.xml is no longer required.