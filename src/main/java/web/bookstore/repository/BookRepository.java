package web.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import web.bookstore.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
