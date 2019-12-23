package payroll.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import payroll.dao.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findByName(String name);
}
