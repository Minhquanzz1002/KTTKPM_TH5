package vn.edu.iuh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.model.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
