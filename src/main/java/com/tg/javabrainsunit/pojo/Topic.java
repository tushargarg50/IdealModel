package com.tg.javabrainsunit.pojo;

import java.util.function.Predicate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer priority;
	@Column
	private String name;
	@Column
	private String author;
	@Column
	private String code;
	
	public static Predicate<Topic> authorBasedPredicate(Topic topic) {
		return t -> topic.getAuthor().equals(t.getAuthor());
	}

	public static Predicate<Topic> codeBasedPredicate(Topic topic) {
		return t -> topic.getCode().equals(t.getCode());
	}

	public static Predicate<Topic> nameBasedPredicate(Topic topic) {
		return t -> topic.getName().equals(t.getName());
	}

	public static Predicate<Topic> priorityBasedPredicate(Topic topic) {
		return t -> topic.getPriority().equals(t.getPriority());
	}

}
