package payroll.service;


import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payroll.DAO.Department;
import payroll.DAO.DepartmentRepository;
import payroll.DAO.Employee;
import payroll.DAO.EmployeeRepository;
import payroll.controller.EmployeeDto;
import payroll.controller.EmployeeMapper;
import payroll.exeption.ValidateException;

import java.util.List;

//mapstruct
//Dto myDto = mapper.mapToDao(Dto source)
@Service
public class EmployeeServices {
    EmployeeRepository repository;
    EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);

    @Autowired
    public EmployeeServices(EmployeeRepository repository) {
        this.repository = repository;
    }

    public List<Employee> takeAll() {
        return (List<Employee>) repository.findAll();
    }

    public EmployeeDto createEmployee(EmployeeDto newEmployee) {
        List<Employee> tocheck = (List<Employee>) repository.findAll();
        for (Employee e : tocheck) {
            if (newEmployee.getName().equals(e.getName())) {
                throw new ValidateException();
            }
        }
        Employee employee = mapper.sourceToDestination(newEmployee);
//        departmentRepository.findByName(newEmployee.getDepartmentname()).map
        repository.save(employee);
        return newEmployee;
    }

    public List<Employee> takeByName(String name) {
        return repository.findByName(name);
    }

    public EmployeeDto updateEmployee(EmployeeDto newEmployee, Long id) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setName(newEmployee.getName());
                    employee.setRole(newEmployee.getRole());
                    repository.save(employee);
                    return newEmployee;
                })
                .orElseGet(() -> {
                    Employee employee = mapper.sourceToDestination(newEmployee);
                    repository.save(employee);
                    return newEmployee;
//                    newEmployee.setId(id);
//                    return repository.save(newEmployee);
                });
    }

    public void removeEmployee(Long id) {
        repository.deleteById(id);
    }
    public Department takeOne(Long id){
        return repository.findById(id).get().getDepartment();
    }
}
