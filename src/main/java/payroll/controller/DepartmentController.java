package payroll.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import payroll.dao.Department;
import payroll.dto.DepartmentDto;
import payroll.service.DepartmentService;

import java.util.List;

@RestController
public class DepartmentController {

    DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/departments/all")
    List<Department> all() {
        return departmentService.takeAll();
    }

    @PostMapping
    ResponseEntity<String> newDepartment(@RequestParam DepartmentDto departmentDTO) {
        departmentService.createDepartment(departmentDTO);
        return ResponseEntity.ok("Employee added");
    }

    @GetMapping("/departments")
    Department name(@RequestParam(value = "name") String name) {
        return departmentService.takeByName(name);
    }
}
