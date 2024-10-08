package cibertec.edu.pe.T2_JV_JM.dto;

import cibertec.edu.pe.T2_JV_JM.model.Author;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Builder
@Data
public class AuthorDto extends Author {
    private Integer authorId;
    private String firstName;
    private String lastName;
    private String biography;
}
