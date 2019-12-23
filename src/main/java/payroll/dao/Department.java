package payroll.dao;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "DEPARTMENT")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department")
    @JsonManagedReference
    private List<Employee> employeeList;

    public Department(String name) {
        this.name = name;
    }
}
