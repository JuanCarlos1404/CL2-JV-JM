package cibertec.edu.pe.T2_JV_JM.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class OrderDetailDto {
    private Integer orderId;
    private Integer bookId;
    private Integer quantity;
    private BigDecimal price;
}
