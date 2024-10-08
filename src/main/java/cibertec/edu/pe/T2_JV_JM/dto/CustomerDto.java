package cibertec.edu.pe.T2_JV_JM.dto;

import cibertec.edu.pe.T2_JV_JM.model.Customer;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerDto extends Customer {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
