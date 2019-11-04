package payroll.controller;

import org.mapstruct.Mapper;
import payroll.DAO.Department;

@Mapper
public interface DepartmentMapper {
    Department sourceToDestination(DepartmentDto dto);
    DepartmentDto destinationToSource  (Department department);
}

