package payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import payroll.dao.Department;
import payroll.dao.Employee;
import payroll.dto.EmployeeDto;
import payroll.dto.OrderDto;
import payroll.exception.EmployeeNameLengthException;
import payroll.service.EmployeeServices;

import javax.validation.Valid;
import java.util.List;

@RestController
class EmployeeController {
    EmployeeServices employeeServices;

    @Autowired
    EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    // Aggregate root

    @GetMapping("/employees/{id}/department")
    Department one(@PathVariable Long id) {
        return employeeServices.takeOne(id);
    }

    @PostMapping("/employees/{id}/employeeorder")
    ResponseEntity<String> createOrder(@PathVariable Long id, @RequestBody OrderDto dto) {
        return employeeServices.setOrder(id,dto);
    }

    @GetMapping("/employees/all")
    List<Employee> all() {
        return employeeServices.takeAll();
    }

    @PostMapping("/employees")
    ResponseEntity<String> newEmployee(@Valid @RequestBody EmployeeDto newEmployee) {
        if (newEmployee.getName().length() > 15) {
            throw new EmployeeNameLengthException();
        }
        employeeServices.createEmployee(newEmployee);
        return ResponseEntity.ok("Employee added");
    }


    @GetMapping("/employees")
    List<Employee> name(@RequestParam(value = "name") String name) {
        return employeeServices.takeByName(name);
    }

    @PutMapping("/employees")
    EmployeeDto replaceEmployee(@RequestBody EmployeeDto newEmployee, @RequestParam(value = "id") Long id) {

        return employeeServices.updateEmployee(newEmployee, id);
    }

    @DeleteMapping("/employees")
    void deleteEmployee(@RequestParam(value = "id") Long id) {
        employeeServices.removeEmployee(id);
    }
}
