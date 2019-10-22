package com.tg.javabrainsunit.pojo;

import static org.junit.Assert.assertEquals;

import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class TopicTest {

	@Test
	public void testTopicArgumentsConstructor() {
		Topic topic = new Topic(1, "a", "a", "a");
		assertEquals(Integer.valueOf(1), topic.getPriority());
		Assert.assertThat(topic.getPriority(), Matchers.equalTo(Integer.valueOf(1)));
		Assertions.assertThat(topic.getPriority()).isEqualTo(Integer.valueOf(1));
		Assertions.assertThat(topic.getCode()).isNotBlank();
		
	}

}
