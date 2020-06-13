package com.example.demo.controller;

import java.util.List;

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
import javax.validation.Valid;

@RestController
public class TestController {

	
	@Autowired 
	AuthorService authService;
	
	// passing the name in request using PathVariable
	@GetMapping("/hello/pv/{name}")
	public TestBean helloPathVariable(@PathVariable String name) {
		return new TestBean(String.format("Hello World, %s", name));
	}
	
	// To get the list of all Authors
	@GetMapping(path="/authors")
	public List<Author> getAll() {
		return authService.getAllAuthors();
	}
	
	//  to retrieve the specfic id
	@GetMapping(path="/author/{id}")
	  public ResponseEntity<Author> getById(@PathVariable("id") Integer id) {
		Author auth = authService.getAuthorById(id);
		return new ResponseEntity<Author>(auth, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	// to add the new author data in database(table= Author)
	@PostMapping("/create")
	public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author auth) throws RecordsNotFoundException {
		Author create = authService.createAuthor(auth);
	 return new ResponseEntity<Author>(create, new HttpHeaders(), HttpStatus.OK);	
		
	}
	
	
	// to delte the specific records in db table
	@DeleteMapping("/delete/{id}")
	public void deleteRecords(@PathVariable(name = "id") Integer id) {
		authService.deleteAuthor(id);
		
		}
	
}
