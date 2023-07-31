package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import peaksoft.enums.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;
@Entity
@Table(name = "books")
@Getter
@Setter

@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "book_gen")
    @SequenceGenerator(name = "book_gen",
                       sequenceName = "book_seq",
                       allocationSize = 1
    )
    private Long id;
    private String name;
    private String country;
    private LocalDate published_year;
    private BigDecimal price;
    private Genre genre;
    @ManyToOne(cascade = {CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE,
            CascadeType.DETACH,
            CascadeType.REFRESH},fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
  private Publisher publisher;
    @ManyToOne(cascade = {CascadeType.PERSIST,
                          CascadeType.MERGE,
                          CascadeType.REMOVE,
                          CascadeType.DETACH,
                          CascadeType.REFRESH})
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(String name, String country, LocalDate published_year, BigDecimal price, Genre genre) {
        this.name = name;
        this.country = country;
        this.published_year = published_year;
        this.price = price;
        this.genre = genre;
    }

    public Book(String name, String country, LocalDate published_year, BigDecimal price, Genre genre, Publisher publisher, Author author) {
        this.name = name;
        this.country = country;
        this.published_year = published_year;
        this.price = price;
        this.genre = genre;
        this.publisher = publisher;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", published_year=" + published_year +
                ", price=" + price +
                ", genre=" + genre +
                '}';
    }
}