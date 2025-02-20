package web.bookstore.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import web.bookstore.domain.Book;
import web.bookstore.dto.BookDto;
import web.bookstore.service.BookService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
@Slf4j
public class BookController {
    private final BookService bookService;
    private final ModelMapper modelMapper;

    // 책 목록 조회
    @GetMapping
    public ResponseEntity<?> getBookList () {
        log.info("getBookList 호출");
        List<BookDto> result = bookService.getBookList().stream()
                .map(data -> {
                    BookDto bookDto = modelMapper.map(data, BookDto.class);
                    if(data.getPubDate() != null) {
                        bookDto.setPubDate(data.getPubDate().toString());
                        return bookDto;
                    } return bookDto;
                }).toList();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 책 상세 정보 조회
    @GetMapping("/{id}")
    public ResponseEntity<?> getBookInfo (@PathVariable int id) {
        log.info("getBookInfo 호출");
        Book book = bookService.getBookInfo(id);
        BookDto result = modelMapper.map(book, BookDto.class);
        result.setPubDate(book.getPubDate().toString());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 책 추가
    @PostMapping
    public ResponseEntity<?> addBook (@RequestBody BookDto book) {
        log.info("addBook 호출");
        log.info("pubdate : {}", book.getPubDate());
        LocalDate date = LocalDate.parse(book.getPubDate(), DateTimeFormatter.BASIC_ISO_DATE);
        Book dbBook = modelMapper.map(book, Book.class);
        dbBook.setPubDate(date);
        Book result = bookService.addBook(dbBook);
        BookDto dto = modelMapper.map(result, BookDto.class);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    // 책 정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook (@PathVariable int id, @RequestBody BookDto book) {
        log.info("updateBook 호출");
        BookDto result = modelMapper.map(bookService.updateBook(id, modelMapper.map(book, Book.class)), BookDto.class);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    // 책 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook (@PathVariable int id) {
        log.info("deleteBook 호출");
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
