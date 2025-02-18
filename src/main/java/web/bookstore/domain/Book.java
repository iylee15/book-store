package web.bookstore.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private long price;
    @Column(nullable = true)
    private String publisher;
    @Column(nullable = true)
    private LocalDate pubDate;
    @Column(nullable = true, length = 2000)
    private String description;
    @Column(nullable = false)
    private int stock;
    @Column(nullable = true)
    private String isbn;
    @Column(nullable = true)
    private String link;
    @Column(nullable = true)
    private String image;
}
