package greet.greetingservice.Service;

import greet.greetingservice.Domain.Book;

import java.util.Collection;

public interface BookService {
    public Book getBookByIsbn(String isbn);
    public Collection<?> getAllBooks();
    public void addBook(Book bk);
    public void deleteBook(String isbn);
}
