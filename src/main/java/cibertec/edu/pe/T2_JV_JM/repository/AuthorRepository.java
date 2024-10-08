package cibertec.edu.pe.T2_JV_JM.repository;

import cibertec.edu.pe.T2_JV_JM.dto.AuthorDto;
import cibertec.edu.pe.T2_JV_JM.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
    List<AuthorDto> findByFirstName(String firstName);
    List<AuthorDto> findByBiographyContaining(String keyword);

    @Query("SELECT a FROM Author a WHERE a.firstName = ?1 AND a.lastName = ?2")
    Author findByFullName(String firstName, String lastName);

    @Query("SELECT a FROM Author a")
    List<Author> findAllAuthors();

    @Query(value = "SELECT * FROM Author WHERE authorId = ?1", nativeQuery = true)
    Author findAuthorById(Long authorId);

    @Query(value = "SELECT COUNT(*) FROM Author", nativeQuery = true)
    Long countAuthors();
}
