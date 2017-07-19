package io.slawek.springbootstarter.lesson;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LessonService {
	
	@Autowired
	private LessonRepository lessonRepository;

	public List<Lesson> getAllLessons() { return (List<Lesson>) lessonRepository.findAll(); }
	
	public Lesson getLessonById(Long id) {
	    return lessonRepository.findOne(id);
	}

	public Lesson addLesson(Lesson lesson) {
		lessonRepository.save(lesson);
		return lesson;
	}

	public void updateLesson(Lesson lesson) {
	    lessonRepository.save(lesson);
	}

	public void deleteLessonById(Long id) {
	    lessonRepository.delete(id);
	}
		
}
