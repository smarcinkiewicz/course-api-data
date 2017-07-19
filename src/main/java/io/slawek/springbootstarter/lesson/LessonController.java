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

@RestController
public class LessonController {
	
	@Autowired
	private LessonService lessonService;
	
	@RequestMapping("topics/{topicId}/courses/{id}/lessons")
	public List<Lesson> getAllLessons() {
		return lessonService.getAllLessons();
	}
	
	@RequestMapping("topics/{topicId}/courses/{courseId}/lessons/{id}")
	public Lesson getLessonById(@PathVariable Long id) {
		return lessonService.getLessonById(id);
	}
	
	@PostMapping("/topics/{topicId}/courses/{courseId}/lessons")
	public Lesson addLesson(@RequestBody Lesson lesson) {
		lessonService.addLesson(lesson);
		return lesson;
	}
	
	@PutMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void updateLesson(@RequestBody Lesson lesson) {
		lessonService.updateLesson(lesson);
	}
	
	@DeleteMapping("/topics/{topicId}/courses/{courseId}/lessons/{id}")
	public void deleteLessonById(@PathVariable Long id) {
		lessonService.deleteLessonById(id);
	}

}
