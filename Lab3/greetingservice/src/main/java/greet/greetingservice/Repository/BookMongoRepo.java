package greet.greetingservice.Repository;

import greet.greetingservice.Domain.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookMongoRepo extends JpaRepository<String, Book> {
}
