package web.bookstore.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
    private int id;
    private String title;
    private String author;
    private long price;
    private String publisher;
    private String pubDate;
    private String description;
    private int stock;
    private String isbn;
    private String link;
    private String image;
}
