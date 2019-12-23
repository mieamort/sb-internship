package payroll.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String name;
    private String role;
    private Integer wallet;
    private String departmentname;
}
