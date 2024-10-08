package cibertec.edu.pe.T2_JV_JM.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CuatomerDto {
    private Integer customerId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
