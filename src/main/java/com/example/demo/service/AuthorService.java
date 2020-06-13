package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.bean.Author;
import com.example.demo.exception.RecordsNotFoundException;
import com.example.demo.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authRepository;
	
		
	@Transactional
	public List<Author> getAllAuthors() {
		return (List<Author>) authRepository.findAll();
		
	}
	
	
	@Transactional
	public Author getAuthorById(Integer id) throws RecordsNotFoundException {
		Optional<Author> author =authRepository.findById(id);
		
		if(author.isPresent()) {
			return author.get();
		} else {
			throw new RecordsNotFoundException("No records found for given Id");
		}
		
	}		
		
	
	
	public Author createAuthor(Author author) {
		return authRepository.save(author);
	}
		
	
		
	public void deleteAuthor(Integer id) {
		 authRepository.deleteById(id);
		 
	}
}
