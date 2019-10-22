package com.tg.javabrainsunit.repo;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.tg.javabrainsunit.pojo.Topic;
import com.tg.javabrainsunit.service.api.TopicService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
public class CachingTest {
	
	@Autowired
	private TopicService topicServiceDB;
	
	@MockBean
	private TopicRepository topicRepo;

	@Test
	public void testCaching() {
		
		List<Topic> topicList = new ArrayList<>();
		topicList.add(new Topic(1, "A", "a", "A"));
		topicList.add(new Topic(2, "a", "a", "a"));
		when(topicRepo.findByAuthor(anyString())).thenReturn(topicList);
		
		topicServiceDB.getTopicBasedOnAuthor("a");
		topicServiceDB.getTopicBasedOnAuthor("a");
		
		verify(topicRepo, times(1)).findByAuthor("a");
	}

}
