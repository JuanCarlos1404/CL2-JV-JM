package cibertec.edu.pe.T2_JV_JM.service;

import cibertec.edu.pe.T2_JV_JM.dto.AuthorDto;
import cibertec.edu.pe.T2_JV_JM.model.Author;

import java.util.List;


public interface IAuthorService {
    Author saveAuthor(Author author);
    AuthorDto findAuthorById(Integer authorId);
    List<AuthorDto> findByFirstName(String firstName);
    List<AuthorDto> findByBiography(String keyword);
    Author findByFullName(String firstName, String lastName);
    List<AuthorDto> findAllAuthors();
    Long countAuthors();
}
