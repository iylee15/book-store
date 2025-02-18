package web.bookstore.service;

import web.bookstore.domain.Book;

import java.util.List;

public interface BookService {
    // 책 목록 조회
    public List<Book> getBookList();

    // 책 상세 정보 조회
    public Book getBookInfo(int id);

    // 책 추가
    public Book addBook(Book book);

    // 책 정보 수정
    public Book updateBook(int id, Book book);

    // 책 삭제
    public void deleteBook(int id);
}
