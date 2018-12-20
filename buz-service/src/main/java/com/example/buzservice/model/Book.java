package com.example.buzservice.model;

import lombok.Data;

/**
 * @author luxp
 * @date 2018/12/19
 */
@Data
public class Book {
	private Integer id;

	private String name;

	private String author;

	public Book(String name, String author) {
		this.name = name;
		this.author = author;
	}

	public Book(Integer id, String name, String author) {
		this.id = id;
		this.name = name;
		this.author = author;
	}
}
