package cibertec.edu.pe.T2_JV_JM.model;

import cibertec.edu.pe.T2_JV_JM.dto.AuthorDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Author")
public class Author{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;

    private String firstName;
    private String lastName;
    private String biography;
}
