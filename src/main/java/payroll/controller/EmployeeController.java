package payroll.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import payroll.DAO.Department;
import payroll.DAO.Employee;
import payroll.exeption.EmployeeNameLengthException;
import payroll.service.EmployeeServices;

import javax.validation.Valid;

@RestController
class EmployeeController {
    EmployeeServices employeeServices;

    @Autowired
    EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    // Aggregate root

    @GetMapping("/employees/{id}/department")
    Department one(@PathVariable Long id){
        return employeeServices.takeOne(id);
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

    // Single item


    @GetMapping("/employees")
    List<Employee> name(@RequestParam(value = "name") String name) {
        return employeeServices.takeByName(name);
    }

//    @GetMapping("/employees/{name}")
//    List<Employee> name (@PathVariable String name){
//        List <Employee> all =(List<Employee>) repository.findAll();
//        List<Employee> needed = new ArrayList<Employee>();
//        for (Employee e: all) {
//            if (e.getName().equals(name)){
//                needed.add(e);
//            }
//        }
//        return needed;
//    }

    @PutMapping("/employees")
    EmployeeDto replaceEmployee(@RequestBody EmployeeDto newEmployee, @RequestParam(value = "id") Long id) {

        return employeeServices.updateEmployee(newEmployee, id);
    }

    @DeleteMapping("/employees")
    void deleteEmployee(@RequestParam(value = "id") Long id) {
        employeeServices.removeEmployee(id);
    }
}
