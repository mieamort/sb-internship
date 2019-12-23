package payroll.mappers;

import org.mapstruct.Mapper;
import payroll.dao.Employee;
import payroll.dto.EmployeeDto;

@Mapper
public interface EmployeeMapper {
    Employee sourceToDestination(EmployeeDto dto);

    EmployeeDto destinationToSource(Employee employee);
}
