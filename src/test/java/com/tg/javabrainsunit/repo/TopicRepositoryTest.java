package com.tg.javabrainsunit.repo;

import java.util.Collection;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.tg.javabrainsunit.pojo.Topic;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TopicRepositoryTest {
	
	@Autowired
	private TopicRepository topicRepository;

	@Test
	public void testFindByAuthor() {
		topicRepository.save(new Topic(null, "e", "e", "e"));
		Collection<Topic> byAuthor = topicRepository.findByAuthor("e");
		Assertions.assertThat(byAuthor).isNotNull();
		Assertions.assertThat(byAuthor).isNotEmpty();
		Assertions.assertThat(byAuthor.size()).isEqualTo(1);
		Assertions.assertThat(byAuthor.iterator().next().getAuthor()).isEqualTo("e");
	}

	@Test
	public void testFindByAuthorWithoutInsertingData() {
		Collection<Topic> byAuthor = topicRepository.findByAuthor("e");
		Assertions.assertThat(byAuthor).isNotNull();
		Assertions.assertThat(byAuthor).isEmpty();;
		Assertions.assertThat(byAuthor.size()).isEqualTo(0);
	}
}
