package cibertec.edu.pe.T2_JV_JM.service;

import cibertec.edu.pe.T2_JV_JM.exception.ResourceNotFoundException;
import cibertec.edu.pe.T2_JV_JM.model.Author;
import cibertec.edu.pe.T2_JV_JM.repository.AuthorRepository;
import cibertec.edu.pe.T2_JV_JM.service.impl.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public Author findAuthorById(Long authorId) {
        return authorRepository.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("Author not found"));
    }

    @Override
    public List<Author> findByFirstName(String firstName) {
        return authorRepository.findByFirstName(firstName);
    }

    @Override
    public List<Author> findByBiography(String keyword) {
        return authorRepository.findByBiographyContaining(keyword);
    }

    @Override
    public Author findByFullName(String firstName, String lastName) {
        return authorRepository.findByFullName(firstName, lastName);
    }

    @Override
    public List<Author> findAllAuthors() {
        return authorRepository.findAllAuthors();
    }

    @Override
    public Long countAuthors() {
        return authorRepository.countAuthors();
    }
}

}
