package cibertec.edu.pe.T2_JV_JM.model.pk;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ProductOrderId {
    private Integer orderId;
    private Integer bookId;
}
