package vn.edu.iuh.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import vn.edu.iuh.model.Course;
import vn.edu.iuh.repository.CourseRepository;
import vn.edu.iuh.service.CourseService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    private CourseRepository repository;
    @Override
    public Course save(Course course) {
        return repository.save(course);
    }

    @Override
    public List<Course> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Course> findById(long id) {
        return repository.findById(id);
    }
}
