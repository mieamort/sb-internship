package payroll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import payroll.DAO.Department;
import payroll.DAO.DepartmentRepository;
import payroll.DAO.Employee;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SbInternApplication {


    public static void main(String[] args) {
        SpringApplication.run(SbInternApplication.class, args);
        SbInternApplication sbInternApplication = new SbInternApplication();
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
    }

}

