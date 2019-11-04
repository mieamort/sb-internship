package payroll.DAO;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PreLoad implements ApplicationRunner {
    @Autowired
    DepartmentRepository departmentRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        final Department department = new Department("РБ");
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Dan", "Prog", department));
        employees.add(new Employee("San", "Prog", department));
        employees.add(new Employee("Van", "Prog", department));
        employees.add(new Employee("Kin", "Prog", department));
        department.setEmployeeList(employees);
        final Department department1 = new Department("Techno");
        List<Employee> employees1 = new ArrayList<>();
        employees1.add(new Employee("Tom","hr",department1));
        employees1.add(new Employee("Pit","prog",department1));
        employees1.add(new Employee("Al","PO",department1));
        department1.setEmployeeList(employees1);
        departmentRepository.saveAll(Arrays.asList(department,department1));
    }
}
