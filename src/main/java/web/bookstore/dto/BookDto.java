package web.bookstore.dto;

import jakarta.persistence.Column;

import java.time.LocalDate;

public class BookDto {
    private int id;
    private String title;
    private String author;
    private long price;
    private String publisher;
    private LocalDate pubDate;
    private String description;
    private int stock;
}
