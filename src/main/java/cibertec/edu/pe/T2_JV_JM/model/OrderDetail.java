package cibertec.edu.pe.T2_JV_JM.model;

import cibertec.edu.pe.T2_JV_JM.model.pk.ProductOrderId;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "OrderDetail")
public class OrderDetail {
    @EmbeddedId
    private ProductOrderId orderDetailId;

    private Integer quantity;
    private BigDecimal price;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "orderId")
    @JsonBackReference
    private Order order;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "bookId")
    private Book book;
}
