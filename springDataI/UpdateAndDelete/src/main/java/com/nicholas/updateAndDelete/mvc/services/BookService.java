package com.nicholas.updateAndDelete.mvc.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nicholas.updateAndDelete.mvc.models.Book;
import com.nicholas.updateAndDelete.mvc.repositories.BookRepository;

import java.util.List;

@Service
public class BookService {
	// adding the book repository as a dependency
	private final BookRepository bookRepository;
	
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	 // returns all the books
    public List<Book> allBooks() {
        return bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    //updates a book
    public Book updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
    	Book book = this.findBook(id);
    	
    	book.setTitle(title);
    	book.setDescription(desc);
    	book.setLanguage(lang);
    	book.setNumberOfPages(numOfPages);
    	
    	bookRepository.save(book);
    	return book;
    }
    
    //deletes a book 
    public void deleteBook(Long id) {
    	bookRepository.deleteById(id);
    	}
    
    // retrieves a book
    public Book findBook(Long id) {
    	// optional means it could exist or not
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
    
   
}
