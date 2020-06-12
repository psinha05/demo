package com.example.demo.controller;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Author;
import com.example.demo.bean.TestBean;
import com.example.demo.exception.RecordsNotFoundException;
import com.example.demo.service.AuthorService;


@RestController
public class TestController {

	
	@Autowired 
	AuthorService authService;
	
	@GetMapping("/")
	public String helloTest() {
		return "Hello REST API";
	}
	
	
	@GetMapping("/hello")
	public TestBean helloBean() {
		return new TestBean("Hello BEaNNNNn");
	}
	

	@GetMapping("/hello/pv/{name}")
	public TestBean helloPathVariable(@PathVariable String name) {
		return new TestBean(String.format("Hello World, %s", name));
	}
	
	
	@GetMapping(path="/authors")
	public List<Author> getAll() {
		
		return authService.getAllAuthors();
	}
	
	
	@GetMapping(path="/author/{id}")
	  public ResponseEntity<Author> getById(@PathVariable("id") Integer id) {
		Author auth = authService.getAuthorById(id);
		
		// HATEOAS Implementation
		return new ResponseEntity<Author>(auth, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	@PostMapping("/jpa")
	public ResponseEntity<Author> createAuthor(@RequestBody Author auth) throws RecordsNotFoundException {
		Author create = authService.createAuthor(auth);
	 return new ResponseEntity<Author>(create, new HttpHeaders(), HttpStatus.OK);	
		
	}
	
	
	@DeleteMapping("/delete/{id}")
	public void deleteRecords(@PathVariable(name = "id") Integer id) {
		authService.deleteAuthor(id);
		
		/*
		 * if(auth==null) { throw new RecordsNotFoundException("id-" +id); }
		 */
	}
	
}
