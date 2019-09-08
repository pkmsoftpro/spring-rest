package SpringRest.spring_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EmployeeNotFoundExcpetion extends RuntimeException {

	public EmployeeNotFoundExcpetion(String message) {
		super(message);
	}
}
