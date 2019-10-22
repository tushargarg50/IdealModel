package com.tg.javabrainsunit.service.api;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import com.tg.javabrainsunit.pojo.Topic;

public interface TopicService {

	public List<Topic> getAllTopics();

	public Topic getTopic(Predicate<Topic> predicate);

	public Topic updateTopic(Integer id, Topic topic);

	public boolean removeTopic(Integer id);

	public boolean addTopic(Topic topic);
	
	public Collection<Topic> getTopicBasedOnAuthor(String author);

}
