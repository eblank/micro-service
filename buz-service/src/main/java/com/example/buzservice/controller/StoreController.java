package com.example.buzservice.controller;

import com.example.buzservice.model.Book;
import com.example.buzservice.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author luxp
 * @date 2018/12/19
 */
@RestController
@Slf4j
public class StoreController {
	@Resource
	private BookRepository bookRepository;

	@Resource
	private DiscoveryClient discoveryClient;

	@GetMapping("/book/store")
	public String store() {
		String description = discoveryClient.description();
		log.info("name: {}", description);
		return description;
	}

	@GetMapping("/book/list")
	public List<Book> list() {
		return bookRepository.list();
	}

	@GetMapping("/book/name/{name}")
	public List<Book> name(@PathVariable String name) {
		return bookRepository.getByName(name);
	}

	@GetMapping("/book/author/{author}")
	public List<Book> author(@PathVariable String author) {
		return bookRepository.getByAuthor(author);
	}

	@PutMapping("/book")
	public Book add(@RequestBody Book book) {
		bookRepository.add(book);
		return book;
	}

	@PostMapping("/book")
	public Book add(@RequestParam String name, @RequestParam String author) {
		Book book = new Book(name, author);
		bookRepository.add(book);
		return book;
	}

	@DeleteMapping("/book/name/{name}")
	public boolean removeByName(@PathVariable String name) {
		return bookRepository.removeByName(name);
	}

	@DeleteMapping("/book/author/{author}")
	public boolean removeByAuthor(@PathVariable String author) {
		return bookRepository.removeByAuthor(author);
	}
}
