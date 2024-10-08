package cibertec.edu.pe.T2_JV_JM.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "Book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String title;
    private String genre;
    private BigDecimal price;
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private Author author;
}
