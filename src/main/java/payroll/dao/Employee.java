package payroll.dao;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String role;

    @Column
    private Integer wallet;


    @ManyToOne
    @JoinColumn(name = "DEPT_ID")
    @JsonBackReference
    private Department department;

    public Employee(String name, String role, Department department, Integer wallet) {
        this.name = name;
        this.role = role;
        this.department = department;
        this.wallet=wallet;
    }
}
