package com.jung.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jung.domain.Author;
import com.jung.domain.Book;
import com.jung.repo.AuthorRepository;
import com.jung.repo.BookRepository;

@RestController
public class HelloController {
	
	private final AuthorRepository authoRepo;
	private final BookRepository bookRepo;
	public HelloController(AuthorRepository authoRepo,BookRepository bookRepo) {
		this.authoRepo = authoRepo;
		this.bookRepo = bookRepo;
	}
	
	@GetMapping("/hello")
	public String hello(){
		return "Hello from Hello Controller.<br> Time is "+LocalDateTime.now();
	}
	@GetMapping("/authors")
	public List<Author> getAllAuthor(){
		return authoRepo.findAll();
	}
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
}
