package cibertec.edu.pe.T2_JV_JM.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class BookDto {
    private Integer bookId;
    private String title;
    private Integer authorId;
    private String genre;
    private BigDecimal price;
    private Integer stock;
}
