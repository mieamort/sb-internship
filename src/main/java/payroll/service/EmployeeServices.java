package payroll.service;


import lombok.extern.log4j.Log4j2;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import payroll.dao.Department;
import payroll.dao.Employee;
import payroll.dto.EmployeeDto;
import payroll.dto.OrderDto;
import payroll.exception.NoMoneyException;
import payroll.exception.ValidateException;
import payroll.mappers.EmployeeMapper;
import payroll.repository.DepartmentRepository;
import payroll.repository.EmployeeRepository;

import java.util.List;


@Log4j2
@Service
public class EmployeeServices {
    EmployeeRepository repository;
    DepartmentRepository departmentRepository;
    OrderService service2;
    EmployeeMapper mapper = Mappers.getMapper(EmployeeMapper.class);

    @Autowired
    public EmployeeServices(EmployeeRepository repository, DepartmentRepository departmentRepository, OrderService service2) {
        this.service2 = service2;
        this.repository = repository;
        this.departmentRepository = departmentRepository;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public ResponseEntity<String> setOrder(Long id, OrderDto dto) {
        if (dto.getClientName() == null) {
            dto.setClientName(repository.findById(id).get().getName());
        }
        repository.findById(id).map(employee -> {
            employee.setWallet(repository.findById(id).get().getWallet() - dto.getCost());
            repository.save(employee);
            return employee;
        });
        if (repository.findById(id).get().getWallet() < 0) throw new NoMoneyException();

        return service2.postOrder(dto);
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
        employee.setDepartment(departmentRepository.findByName(newEmployee.getDepartmentname()));
        departmentRepository.findByName(newEmployee.getDepartmentname()).getEmployeeList().add(employee);
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
                });
    }

    public void removeEmployee(Long id) {
        repository.deleteById(id);
    }

    public Department takeOne(Long id) {
        return repository.findById(id).get().getDepartment();
    }
}
