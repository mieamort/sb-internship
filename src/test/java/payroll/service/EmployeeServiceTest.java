package payroll.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import payroll.dao.Employee;
import payroll.repository.EmployeeRepository;

import java.util.List;

import static org.hamcrest.Matchers.any;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {
    @Mock
    EmployeeRepository mockrep;

    @Mock
    Employee mockemp;

    @Autowired
    @InjectMocks
    EmployeeServices mockserv;


    @BeforeAll
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    //    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public ResponseEntity<String> setOrder(Long id, OrderDto dto) {
//        if (dto.getClientName() == null) {
//            dto.setClientName(repository.findById(id).get().getName());
//        }
//        repository.findById(id).map(employee -> {
//            employee.setWallet(repository.findById(id).get().getWallet() - dto.getCost());
//            repository.save(employee);
//            return employee;
//        });
//        if (repository.findById(id).get().getWallet() < 0) throw new NoMoneyException();
//
//        return service2.postOrder(dto);
//    }
    @Test
    public void testCreateEmployee() {
        when( mockemp.getName() ).thenReturn( "Sergey" );
        when( mockemp.getRole()).thenReturn( "Kargopolov" );
        when( mockemp.getWallet()).thenReturn( new Integer(10000));
        when( mockemp.getId()).thenReturn( new Long(1) );
        when( mockrep.save(any(Employee.class)) ).thenReturn( mockemp ));

//        List<Employee> tocheck = (List<Employee>) repository.findAll();
//        for (Employee e : tocheck) {
//            if (newEmployee.getName().equals(e.getName())) {
//                throw new ValidateException();
//            }
//        }
//        Employee employee = mapper.sourceToDestination(newEmployee);
//        employee.setDepartment(departmentRepository.findByName(newEmployee.getDepartmentname()));
//        departmentRepository.findByName(newEmployee.getDepartmentname()).getEmployeeList().add(employee);
//        repository.save(employee);
//        return newEmployee;
    }
}
