package greet.greetingservice.Repository;

import greet.greetingservice.Domain.Book;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class BookInMemoryRepo {

    Map<String, Book> bookRegister = new HashMap<>();

    {
        bookRegister.put("001", new Book("001", "Erich Gamma","Gang of Four", 100.0));
        bookRegister.put("002", new Book("002", "Richard Helm","Gang of FourII", 110.0));
    }

    public void addBook(Book book){
        bookRegister.put(book.getIsbn(), book);
    }

    public void deleteBook(String isbn){
        bookRegister.remove(isbn);
    }

    public Book getBook(String isbn) {
        return bookRegister.get(isbn);
    }

    public Collection<Book> getAllBooks(){
        return bookRegister.values();
    }
}
