package payroll.controller;

import org.mapstruct.Mapper;
import payroll.DAO.Employee;

@Mapper
public interface EmployeeMapper {
    Employee sourceToDestination(EmployeeDto dto);
    EmployeeDto destinationToSource(Employee employee);
}
