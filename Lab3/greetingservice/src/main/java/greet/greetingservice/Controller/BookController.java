package greet.greetingservice.Controller;

import greet.greetingservice.Domain.Book;
import greet.greetingservice.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {

    @Autowired
    @Qualifier("BookService2")
    BookService bookService;

    @GetMapping("/getBooks")
    public ResponseEntity<?> getAllBook(){
        return new ResponseEntity<>( bookService.getAllBooks(), HttpStatus.OK);
    }

    @GetMapping("/getBook/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable("isbn") String isbn){
        Book b= bookService.getBookByIsbn(isbn);
        return new ResponseEntity<>(b, HttpStatus.OK);
    }

    @PostMapping("/addBook")
    public void addBook(@RequestBody Book bk){
        bookService.addBook(bk);
    }

    @DeleteMapping("/deleteBook/{isbn}")
    public void deleteBook(String isbn){
        bookService.deleteBook(isbn);
    }
}
