package com.tg.javabrainsunit.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tg.javabrainsunit.pojo.Topic;
import com.tg.javabrainsunit.service.api.TopicService;

@Service("topicService")
public class TopicServiceImpl implements TopicService {
	
	List<Topic> topicList = new ArrayList<>(Arrays.asList(
			new Topic(1, "a", "a", "a"), new Topic(2, "b", "b", "b"),
			new Topic(3, "c", "c", "c"), new Topic(4, "d", "d", "d")));
	
	@Override
	public List<Topic> getAllTopics() {
		return topicList;
	}

	@Override
	public Topic getTopic(Predicate<Topic> predicate) {
		Optional<Topic> found = topicList.stream().filter(predicate).findFirst();
		return found.isPresent() ? found.get() : null;
	}

	@Override
	public Topic updateTopic(Integer id, Topic topic) {
		Optional<Topic> topicFound = topicList.stream().filter(t -> t.getPriority().equals(id)).findFirst();
		if (topicFound.isPresent()) {
			int index = topicList.indexOf(topicFound.get());
			topicList.remove(index);
			topicList.add(index, topic);
		}
		return topic;
	}

	@Override
	public boolean removeTopic(Integer id) {
		return topicList.removeIf(t -> t.getPriority().equals(id));
	}

	@Override
	public boolean addTopic(Topic topic) {
		return topicList.add(topic);
	}
	
	@Override
	public Collection<Topic> getTopicBasedOnAuthor(String author) {
		return topicList.stream().filter(t -> t.getAuthor().equals(author))
				.collect(Collectors.toCollection(ArrayList::new));
	}

}
