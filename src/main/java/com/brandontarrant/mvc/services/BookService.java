package com.brandontarrant.mvc.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.brandontarrant.mvc.models.Book;
import com.brandontarrant.mvc.repositories.BookRepository;

@Service
public class BookService {
	private final BookRepository bookRepo;
	
	public BookService(BookRepository bookRepo) {
		this.bookRepo = bookRepo;
	}
	
	// returns all the books
    public List<Book> allBooks() {
        return bookRepo.findAll();
    }
    
    // creates a book
    public Book createBook(Book b) {
        return bookRepo.save(b);
    }
    
    // retrieves a book
    public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepo.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
    // updates a book if the IDs match
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
		return bookRepo.save(findBook(null));
	}
    
    // deletes a book by the ID
    public void deleteBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		if(optionalBook.isPresent()) {
			bookRepo.deleteById(id);
		}
    }

	public ArrayList<Book> getAllBooks() {
		return null;
	}

}
