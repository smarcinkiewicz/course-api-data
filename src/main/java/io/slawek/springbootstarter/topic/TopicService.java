package io.slawek.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	public List<Topic> getAllTopics() {
		return (List<Topic>) topicRepository.findAll();
	}
	
	public Topic getTopicById(Long id) { return topicRepository.findOne(id); }

	public Topic addTopic(Topic topic) {
			topicRepository.save(topic);
			return topic;
	}

	public void updateTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void deleteTopicById(Long id) {
		topicRepository.delete(id);
	}
}