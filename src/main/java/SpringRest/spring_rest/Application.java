package SpringRest.spring_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("SpringRest.spring_rest.repository")
public class Application 
{
    public static void main( String[] args )
    {
        SpringApplication app = new SpringApplication(Application.class);
        app.run();
    }
}
