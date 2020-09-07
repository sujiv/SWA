package greet.greetingservice.Service;

import greet.greetingservice.Domain.Book;
import greet.greetingservice.Repository.BookInMemoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService1 {

    @Autowired
    BookInMemoryRepo bookRepo;


    public Book getBookByIsbn(String isbn) {
        return bookRepo.getBook(isbn);
    }

    public Collection<?> getAllBooks() {
        return bookRepo.getAllBooks();
    }

    public void addBook(Book bk) {
        bookRepo.addBook(bk);
    }

    public void deleteBook(String isbn) {
        bookRepo.deleteBook(isbn);
    }
}
