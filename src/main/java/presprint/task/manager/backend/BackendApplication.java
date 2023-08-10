package presprint.task.manager.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * 
 * @author PRESPRINT PLC August 2023
 * This Code is mainly for the training of trainee
 * for a communication with a  basic backend service through 
 * ajax call
 *
 */
@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

}
