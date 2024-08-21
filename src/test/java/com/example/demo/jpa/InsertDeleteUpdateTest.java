package com.example.demo.jpa;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.vo.Book;

@SpringBootTest
public class InsertDeleteUpdateTest {

	
	@Autowired
	JpaBookRepository jpaBook;
	
	@Test
	void insertUpdateDelete() {
		Book book01=new Book();
		book01.setBookid("99");
		book01.setBookname("스프링부트 기초");
		book01.setPrice("45000");
		book01.setPublisher("한국폴리텍");
		jpaBook.save(book01);
		
		Optional<Book> selectList = jpaBook.findById("9");
		
		Book book02 = selectList.get();
		book02.setPrice("88000");
		jpaBook.save(book02);
		
		jpaBook.deleteById("4");		
	}
}
