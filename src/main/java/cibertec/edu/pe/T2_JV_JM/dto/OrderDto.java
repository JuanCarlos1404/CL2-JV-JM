package cibertec.edu.pe.T2_JV_JM.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Builder
@Data
public class OrderDto {

    private Integer orderId;
    private Integer customerId;
    private Date orderDate;
    private BigDecimal totalAmount;
}
