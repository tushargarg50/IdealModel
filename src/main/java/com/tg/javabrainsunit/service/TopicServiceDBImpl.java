package com.tg.javabrainsunit.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.tg.javabrainsunit.pojo.Topic;
import com.tg.javabrainsunit.repo.TopicRepository;
import com.tg.javabrainsunit.service.api.TopicService;

@Service("topicServiceDB")
public class TopicServiceDBImpl implements TopicService {

	@Resource
	private TopicRepository topicRepository;

	@Override
	public List<Topic> getAllTopics() {
		return topicRepository.findAll();
	}

	@Override
	public Topic getTopic(Predicate<Topic> predicate) {
		Optional<Topic> found = getAllTopics().stream().filter(predicate).findFirst();
		return found.isPresent() ? found.get() : null;
	}
	
	@Override
	@Cacheable("topic")
	public Collection<Topic> getTopicBasedOnAuthor(String author) {
		return topicRepository.findByAuthor(author);
	}

	@Override
	public Topic updateTopic(Integer id, Topic topic) {
		Optional<Topic> topicFound = topicRepository.findById(id);
		if (topicFound.isPresent()) {
			Topic dbTopic = topicFound.get();
			dbTopic.setAuthor(topic.getAuthor());
			dbTopic.setCode(topic.getCode());
			dbTopic.setName(dbTopic.getName());
			topicRepository.save(dbTopic);
			return dbTopic;
		}
		return topic;
	}

	@Override
	public boolean removeTopic(Integer id) {
		try {
			topicRepository.deleteById(id);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean addTopic(Topic topic) {
		return topicRepository.save(topic) != null;
	}

}
