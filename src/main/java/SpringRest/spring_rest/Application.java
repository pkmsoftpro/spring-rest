package SpringRest.spring_rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 *
 */




@Configuration
@ComponentScan
@EnableWebMvc
public class Application 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
