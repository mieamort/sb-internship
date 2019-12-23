package payroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

//@Import(RabbitConfig.class)
@SpringBootApplication
public class SbInternApplication {


    public static void main(String[] args) {
        SpringApplication.run(SbInternApplication.class, args);
        SbInternApplication sbInternApplication = new SbInternApplication();
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
    }
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}

