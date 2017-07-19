package io.slawek.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	public List<Course> getAllCourses() { return (List<Course>) courseRepository.findAll(); }
	
	public Course getCourseById(Long id) {
		return courseRepository.findOne(id);
	}

	public Course addCourse(Course course) {
		courseRepository.save(course);
		return course;
	}

	public void updateCourse(Course course) {
		courseRepository.save(course);
	}

	public void deleteCourseById(Long id) {
		courseRepository.delete(id);
	}
		
}
