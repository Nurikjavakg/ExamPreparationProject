package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import peaksoft.enums.Gender;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="authors")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE,
            generator = "author_gen")
    @SequenceGenerator(
            name="author_gen",
            sequenceName = "author_seq",
            allocationSize = 1
    )

    private Long id;
    private String first_name;
    private String last_name;
    private String email;
    private LocalDate date_of_birth;
    private String country;
    private Gender gender;
    @OneToMany(mappedBy = "author",fetch = FetchType.LAZY)
    private List<Book> bookList;
    @ManyToMany
    private List<Publisher>publishers;

    public Author(String first_name, String last_name, String email, LocalDate date_of_birth, String country, Gender gender) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.date_of_birth = date_of_birth;
        this.country = country;
        this.gender = gender;

    }
}
