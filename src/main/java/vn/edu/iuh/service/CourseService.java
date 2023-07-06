package vn.edu.iuh.service;

import vn.edu.iuh.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseService {
    Course save(Course course);
    List<Course> findAll();

    void deleteById(long id);
    Optional<Course> findById(long id);
}
