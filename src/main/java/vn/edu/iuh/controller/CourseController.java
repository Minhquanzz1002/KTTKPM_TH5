package vn.edu.iuh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.model.Course;
import vn.edu.iuh.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @PostMapping("/new")
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        try {
            Course _course = courseService.save(course);
            return new ResponseEntity<>(_course, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Course>> findAllCourses() {
        try {
            List<Course> courses = courseService.findAll();
            if (courses.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(courses, HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<HttpStatus> deleteCourse(@RequestParam long id) {
        try {
            courseService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Course> updateCourse(@RequestParam long id, @RequestBody Course course) {
        Optional<Course> courseData = courseService.findById(id);
        if (courseData.isPresent()) {
            Course _course = courseData.get();
            _course.setName(course.getName());
            _course.setDescription(course.getDescription());
            _course.setPrice(course.getPrice());
            System.out.println(_course);
            return new ResponseEntity<>(courseService.save(_course), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
