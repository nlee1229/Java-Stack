package com.nicholas.updateAndDelete.mvc.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nicholas.updateAndDelete.mvc.models.Book;
import com.nicholas.updateAndDelete.mvc.repositories.BookRepository;

import java.util.List;

@Service
public class BookService {
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	 // returns all the bookscopy
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
//    	optional means it could exist or not
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
}