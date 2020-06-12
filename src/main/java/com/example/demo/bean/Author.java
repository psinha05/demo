package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.validation.constraints.Size;

@Entity
@Table(name="AUTHOR")
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	//@Size(min =2, max = 20 ,message ="size must be between 2 and 20")
	private String name;
	private String book_name;
	

	public Author(Integer id, String name, String book_name) {
		super();
		this.id = id;
		this.name = name;
		this.book_name = book_name;
	}


	protected Author() {
	  }
	 
	
	 public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getBook_name() {
		return book_name;
	}

	public void setBook_name(String book_name) {
		this.book_name = book_name;
	}
	
	
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", book_name=" + book_name + "]";
	}
	
	

}
