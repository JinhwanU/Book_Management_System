package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.jpa.JpaBookRepository;
import com.example.demo.vo.Book;

@Controller
public class BookController {

	@Autowired
	JpaBookRepository jpaBook;

	@RequestMapping(value = "/insertBookForm")
	public ModelAndView insertBook() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("insertBook");
		return mav;
	}

	@RequestMapping(value = "/insertBookControl")
	public ModelAndView insertBook2(Book book) {
		jpaBook.save(book);

		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "도서 정보가 추가되었습니다.");
		mav.setViewName("insertBookResult");
		return mav;
	}

	@RequestMapping(value = "/selectBook")
	public ModelAndView viewBook(@RequestParam (name="bookid") String bid) {
		Book b = jpaBook.getById(bid);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", b);
		mav.setViewName("selectBookOne");

		return mav;
	}

	@RequestMapping(value = "/updateBookForm")
	public ModelAndView updateBook(@RequestParam (name="bookid")String bid) {
		Book b = jpaBook.getById(bid);
		ModelAndView mav = new ModelAndView();
		mav.addObject("book", b);
		mav.setViewName("updateBook");
		return mav;
	}

	@RequestMapping(value = "/updateBookControl")
	public ModelAndView updateBook2(Book book) {
		jpaBook.save(book);

		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "도서 정보가 수정되었습니다.");
		mav.setViewName("updateBookResult");
		return mav;
	}

	@RequestMapping(value = "/")
	public ModelAndView allBook() {
		List<Book> allList = jpaBook.selectAllBookSortBookid();

		ModelAndView mav = new ModelAndView();
		mav.addObject("allBook", allList);
		mav.setViewName("selectBookAll");
		return mav;
	}
}
