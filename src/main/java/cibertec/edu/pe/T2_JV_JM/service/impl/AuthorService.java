package cibertec.edu.pe.T2_JV_JM.service.impl;

import cibertec.edu.pe.T2_JV_JM.dto.AuthorDto;
import cibertec.edu.pe.T2_JV_JM.exception.ResourceNotFoundException;
import cibertec.edu.pe.T2_JV_JM.model.Author;
import cibertec.edu.pe.T2_JV_JM.repository.AuthorRepository;
import cibertec.edu.pe.T2_JV_JM.service.IAuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthorService implements IAuthorService {
    private final AuthorRepository authorRepository;


    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public AuthorDto findAuthorById(Integer authorId) {
        return authorRepository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("Author not found"));

    }


    @Override
    public List<AuthorDto> findByFirstName(String firstName) {
        return authorRepository.findByFirstName(firstName);
    }

    @Override
    public List<AuthorDto> findByBiography(String keyword) {
        return authorRepository.findByBiographyContaining(keyword);
    }

    @Override
    public Author findByFullName(String firstName, String lastName) {
        return authorRepository.findByFullName(firstName, lastName);
    }

    @Override
    public List<AuthorDto> findAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Long countAuthors() {
        return authorRepository.countAuthors();
    }
}