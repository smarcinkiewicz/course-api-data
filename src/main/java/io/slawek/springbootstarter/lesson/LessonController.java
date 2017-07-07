package io.slawek.springbootstarter.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.slawek.springbootstarter.course.Course;
import io.slawek.springbootstarter.topic.Topic;

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	@RequestMapping("topics/{topicId}/courses/{id}/lessons")
	public List<Lesson> getAllLessons(@PathVariable String id) {
		return lessonService.getAllLessons(id);
	}
	
	@RequestMapping("topics/{topicId}/courses/{courseId}/lessons/{id}")
	public Lesson getLesson(@PathVariable String id) {
		return lessonService.getLesson(id);
	}
	
	@PostMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public void addLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId) {
		lesson.setTopic(new Topic(topicId, "", ""));
		lesson.setCourse(new Course(courseId, "", "", ""));
		lessonService.addLesson(lesson);
	}
	
	@PutMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void updateLesson(@RequestBody Lesson lesson, @PathVariable String topicId, @PathVariable String courseId, @PathVariable String id) {
		lesson.setTopic(new Topic(topicId, "", ""));
		lesson.setCourse(new Course(courseId, "", "", ""));
		lessonService.updateLesson(lesson);
	}
	
	@DeleteMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void deleteLesson(@PathVariable String id) {
		lessonService.deleteLesson(id);
	}

}
