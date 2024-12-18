package MatriparWeb.apimatripar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:63342")
@SpringBootApplication
public class ApimatriparApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApimatriparApplication.class, args);
	}
     
}
