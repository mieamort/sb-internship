package payroll.service;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import payroll.DAO.Department;
import payroll.DAO.DepartmentRepository;
import payroll.DAO.Employee;
import payroll.controller.DepartmentDto;
import payroll.controller.DepartmentMapper;
import payroll.exeption.ValidateException;

import java.util.List;

@Service
public class DepartmentService {
    DepartmentRepository departmentRepository;
    DepartmentMapper departmentMapper = Mappers.getMapper(DepartmentMapper.class);
    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository=departmentRepository;
    }

    public void createDepartment(DepartmentDto departmentDTO){
        List<Department> tocheck = (List<Department>) departmentRepository.findAll();
        for (Department d : tocheck) {
            if (departmentDTO.getName().equals(d.getName())){
                throw new ValidateException();
            }
        }
        Department department = departmentMapper.sourceToDestination(departmentDTO);
        departmentRepository.save(department);
    }
    public List<Department> takeAll() {
        return (List<Department>)departmentRepository.findAll();
    }
    public Department takeByName(String name) {
        return departmentRepository.findByName(name);
    }



}
