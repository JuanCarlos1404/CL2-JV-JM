package cibertec.edu.pe.T2_JV_JM.repository;

import cibertec.edu.pe.T2_JV_JM.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
