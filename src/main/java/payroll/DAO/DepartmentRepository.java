package payroll.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Long> {
    Department findByName(String name);
}
