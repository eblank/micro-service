package com.example.buzservice.repository;

import com.example.buzservice.model.Book;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author luxp
 * @date 2018/12/19
 */
@Component
public class BookRepository {
	private final AtomicInteger idWorker = new AtomicInteger(0);

	private List<Book> bookCollection;

	@PostConstruct
	public void init() {
		if (bookCollection == null) {
			bookCollection = new ArrayList<>();
		}

		add("设计模式", "四人帮");
		add("Java并发编程实战", "Brian");
		add("深入理解JVM", "周志明");
		add("算法", "Robert");
	}

	public List<Book> list() {
		return bookCollection;
	}

	public List<Book> getByName(String name) {
		return filter(bookCollection, book -> book.getName().equals(name));
	}

	public List<Book> getByAuthor(String author) {
		return filter(bookCollection, book -> book.getAuthor().equals(author));
	}

	public boolean removeByName(String name) {
		return remove(bookCollection, book -> book.getName().equals(name));
	}

	public boolean removeByAuthor(String author) {
		return remove(bookCollection, book -> book.getAuthor().equals(author));
	}

	public void add(Book book) {
		add(book.getName(), book.getAuthor());
	}

	public void add(String name, String author) {
		bookCollection.add(new Book(idWorker.incrementAndGet(), name, author));
	}

	private List<Book> filter(Collection<Book> collection, Predicate<Book> predicate) {
		return collection.stream()
				.filter(predicate)
				.collect(Collectors.toList());
	}

	private boolean remove(Collection<Book> collection, Predicate<Book> predicate) {
		return collection.removeIf(predicate);
	}
}
