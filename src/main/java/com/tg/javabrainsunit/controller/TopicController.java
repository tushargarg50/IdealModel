package com.tg.javabrainsunit.controller;

import static com.tg.javabrainsunit.pojo.Topic.authorBasedPredicate;
import static com.tg.javabrainsunit.pojo.Topic.codeBasedPredicate;
import static com.tg.javabrainsunit.pojo.Topic.nameBasedPredicate;
import static com.tg.javabrainsunit.pojo.Topic.priorityBasedPredicate;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tg.javabrainsunit.pojo.Topic;
import com.tg.javabrainsunit.service.api.TopicService;

@RestController
public class TopicController {

	@Autowired
	@Qualifier("topicServiceDB")
	private TopicService topicService;

	@GetMapping(path = "/topics")
	public List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@GetMapping(path = "/topics/{id}")
	public Topic getTopicBasedOnId(@PathVariable("id") Integer id) {
		return topicService.getTopic(t -> t.getPriority().equals(id));
	}

	@PostMapping(path = "/topics")
	public Topic getTopic(@RequestBody Topic topic) {
		Predicate<Topic> filterBehaviour = null;
		if (topic.getAuthor() != null) {
			filterBehaviour = authorBasedPredicate(topic);
		}
		if (topic.getCode() != null) {
			filterBehaviour = filterBehaviour == null ? codeBasedPredicate(topic)
					: filterBehaviour.and(codeBasedPredicate(topic));
		}
		if (topic.getName() != null) {
			filterBehaviour = filterBehaviour == null ? nameBasedPredicate(topic)
					: filterBehaviour.and(nameBasedPredicate(topic));
		}
		if (topic.getPriority() != null) {
			filterBehaviour = filterBehaviour == null ? priorityBasedPredicate(topic)
					: filterBehaviour.and(priorityBasedPredicate(topic));
		}
		return topicService.getTopic(filterBehaviour);
	}

	@RequestMapping(method = { RequestMethod.PUT, RequestMethod.POST }, path = "/topics/{id}")
	public Topic updateTopic(@PathVariable("id") Integer id, @RequestBody Topic topic) {
		return topicService.updateTopic(id, topic);
	}

	@DeleteMapping(path = "/topics/{id}")
	public String deleteTopic(@PathVariable("id") Integer id) {
		return topicService.removeTopic(id) ? "Deleted!" : "Could not be deleted!";
	}

	@PutMapping(path = "/topics")
	public String addTopic(@RequestBody Topic topic) {
		return topicService.addTopic(topic) ? "New Topic Added" : "Topic Could not be added";
	}

}
