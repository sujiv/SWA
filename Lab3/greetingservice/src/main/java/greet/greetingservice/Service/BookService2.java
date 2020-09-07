package greet.greetingservice.Service;

import greet.greetingservice.Domain.Book;
import greet.greetingservice.Repository.BookMongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookService2 implements BookService {

    @Autowired
    BookMongoRepo bookMongoRepo;

    @Override
    public Book getBookByIsbn(String isbn) {
        return bookMongoRepo.getById(isbn);
    }

    @Override
    public Collection<?> getAllBooks() {
        return bookMongoRepo.findAll();
    }

    @Override
    public void addBook(Book bk) {
        bookMongoRepo.save(bk);
    }

    @Override
    public void deleteBook(String isbn) {
        bookMongoRepo.deleteByid(isbn);
    }
}
