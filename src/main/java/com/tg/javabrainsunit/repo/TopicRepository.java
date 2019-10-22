package com.tg.javabrainsunit.repo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tg.javabrainsunit.pojo.Topic;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

	Collection<Topic> findByAuthor(String author);

}
