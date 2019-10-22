package com.tg.javabrainsunit.repo;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.tg.javabrainsunit.pojo.Topic;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TopicJpaTest {
	
	@Autowired
	private TestEntityManager tem;

	@Test
	public void mapping() {
		Topic topic = tem.persistFlushFind(new Topic(null, "e", "e", "e"));
		Assertions.assertThat(topic.getPriority()).isNotNull();
		Assertions.assertThat(topic.getAuthor()).isNotNull();
		Assertions.assertThat(topic.getAuthor()).isNotBlank();
		Assertions.assertThat(topic.getAuthor()).isEqualTo("e");
		
	}

}
