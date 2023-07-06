package vn.edu.iuh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
