package payroll.mappers;

import org.mapstruct.Mapper;
import payroll.dao.Department;
import payroll.dto.DepartmentDto;

@Mapper
public interface DepartmentMapper {
    Department sourceToDestination(DepartmentDto dto);

    DepartmentDto destinationToSource(Department department);
}

