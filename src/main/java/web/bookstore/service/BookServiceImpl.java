package web.bookstore.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.bookstore.domain.Book;
import web.bookstore.repository.BookRepository;

import java.util.List;

@Service
@Transactional
@DynamicUpdate
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public List<Book> getBookList() {
        System.out.println("service 호출");
        System.out.println(bookRepository.findAll());
        return bookRepository.findAll();
    }

    @Override
    public Book getBookInfo(int id) {
        return bookRepository.findById(id).orElseThrow(()
                -> new RuntimeException("해당하는 정보를 찾을 수 없습니다."));
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(int id, Book book) {
        Book dbBook = bookRepository.findById(id).orElseThrow(()
                -> new RuntimeException("해당하는 정보를 찾을 수 없습니다."));
        if (book.getTitle() != null) dbBook.setTitle(book.getTitle());
        if (book.getAuthor() != null) dbBook.setAuthor(book.getAuthor());
        if (book.getPrice() != 0) dbBook.setPrice(book.getPrice());
        if (book.getPublisher() != null) dbBook.setPublisher(book.getPublisher());
        if (book.getPubDate() != null) dbBook.setPubDate(book.getPubDate());
        if (book.getDescription() != null) dbBook.setDescription(book.getDescription());
        if (book.getStock() != 0) dbBook.setStock(book.getStock());
        if (book.getIsbn() != null) dbBook.setIsbn(book.getIsbn());
        if (book.getLink() != null) dbBook.setLink(book.getLink());
        if (book.getImage() != null) dbBook.setImage(book.getImage());
        return bookRepository.save(dbBook);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
