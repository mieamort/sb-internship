package payroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import payroll.dao.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findByName(String name);
}
