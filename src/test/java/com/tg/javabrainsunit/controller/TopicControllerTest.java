package com.tg.javabrainsunit.controller;

import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.tg.javabrainsunit.pojo.Topic;
import com.tg.javabrainsunit.service.api.TopicService;

@RunWith(SpringRunner.class)
@WebMvcTest
public class TopicControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean(name = "topicServiceDB")
	private TopicService topicService;

	@Test
	public void testGetAllTopics() throws Exception {
		Mockito.when(topicService.getAllTopics())
				.thenReturn(new ArrayList<Topic>(Arrays.asList(new Topic(1, "a", "a", "a"))));
		mockMvc.perform(MockMvcRequestBuilders.get("/topics")).andExpect(status().isOk())
		.andExpect(jsonPath("@.[0].author").value("a"));
		
	}

	@Ignore
	@Test
	public void testGetTopicBasedOnId() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testGetTopic() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testUpdateTopic() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testDeleteTopic() {
		fail("Not yet implemented");
	}

	@Ignore
	@Test
	public void testAddTopic() {
		fail("Not yet implemented");
	}

}
