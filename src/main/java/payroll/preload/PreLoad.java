package payroll.preload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import payroll.dao.Department;
import payroll.dao.Employee;
import payroll.repository.DepartmentRepository;

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
        employees.add(new Employee("Dan", "Prog", department, 100000));
        employees.add(new Employee("San", "Prog", department, 100000));
        employees.add(new Employee("Van", "Prog", department, 100000));
        employees.add(new Employee("Kin", "Prog", department, 100000));
        department.setEmployeeList(employees);
        final Department department1 = new Department("Techno");
        List<Employee> employees1 = new ArrayList<>();
        employees1.add(new Employee("Tom", "hr", department1, 100000));
        employees1.add(new Employee("Pit", "prog", department1, 100000));
        employees1.add(new Employee("Al", "PO", department1, 100000));
        department1.setEmployeeList(employees1);
        departmentRepository.saveAll(Arrays.asList(department, department1));
    }
}
