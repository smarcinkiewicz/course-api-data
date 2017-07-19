package io.slawek.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;
	
	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}
	
	@GetMapping("topics/{id}")
	public Topic getTopicById(@PathVariable Long id) {
		return topicService.getTopicById(id);
	}
	
	@PostMapping("/topics")
	public Topic addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return topic;
	}
	
	@PutMapping("/topics/{id}")
	public void updateTopic(@RequestBody Topic topic) {
		topicService.updateTopic(topic);
	}
	
	@DeleteMapping("/topics/{id}")
	public void deleteTopicById(@PathVariable Long id) {
		topicService.deleteTopicById(id);
	}

}
