package cibertec.edu.pe.T2_JV_JM.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthorDto {
    private Integer authorId;
    private String firstName;
    private String lastName;
    private String biography;
}
