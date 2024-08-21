package com.example.demo.jpa;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.vo.Book;

@SpringBootTest
public class SelectTest {
	
	@Autowired
	JpaBookRepository jpaBook;
	
	@Test
	void select() {
		List<Book> allBook=jpaBook.findAll();
		System.out.println("JpaBookRepository:allBook()="+allBook);
		
		Optional<Book> book = jpaBook.findById("9");
		
		System.out.println("JpaBookRepository:findById()="+book);
	}
	
}
