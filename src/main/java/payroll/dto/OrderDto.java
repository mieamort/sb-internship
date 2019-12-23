package payroll.dto;

import lombok.Data;

@Data
public class OrderDto {
    private String orderName;
    private long id;
    private String clientName;
    private Integer cost;
}
