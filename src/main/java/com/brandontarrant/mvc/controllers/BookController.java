package com.brandontarrant.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.brandontarrant.mvc.models.Book;
import com.brandontarrant.mvc.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
//	@GetMapping("/books/{bookID}")
//	public String index(Model model, @PathVariable("bookID") Long bookID) {
//		
//		System.out.println(bookID);
//		Book book = bookService.findBook(bookID);
//		System.out.println(book);
//		
//		ArrayList<Book> books = (ArrayList<Book>) bookService.allBooks();
//		
//		model.addAttribute("book", book);
//		model.addAttribute("books", books);
//		
//		return "index.jsp";
//	}
	
	@GetMapping("/books/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		
		Book book = bookService.findBook(id);
		
		model.addAttribute("book", book);

		return "show.jsp";
	}
	
	@GetMapping("/books")
	public String index(Model model) {
		
		List<Book> books = bookService.allBooks();
		
		model.addAttribute("books", books);

		return "index.jsp";
	}
	
}
