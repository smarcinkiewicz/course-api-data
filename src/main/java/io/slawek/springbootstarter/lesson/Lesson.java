package io.slawek.springbootstarter.lesson;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.slawek.springbootstarter.course.Course;
import io.slawek.springbootstarter.topic.Topic;

@Entity
public class Lesson {

	@Id
	private String id;
	private String name;
	private String description;
	@ManyToOne
	private Course course;
	@ManyToOne
	private Topic topic;
	
	public Lesson() {	
	}
	
	public Lesson(String id, String name, String description, String topicId, String courseId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId, "", "");
		this.course = new Course(courseId, "", "", "");
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
}
