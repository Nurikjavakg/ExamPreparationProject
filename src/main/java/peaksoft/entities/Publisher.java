package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "publishers")
@Getter
@Setter
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "publisher_gen")
    @SequenceGenerator(
                      name="publisher_gen",
                      sequenceName = "publisher_seq",
                      allocationSize = 1)
    private Long id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "publisher",fetch = FetchType.EAGER)
    private List<Book> bookList;
    @ManyToMany(mappedBy = "publishers")
    private List<Author>authors;

    public Publisher(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public Publisher(String name, String address, List<Book> bookList, List<Author> authors) {
        this.name = name;
        this.address = address;
        this.bookList = bookList;
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
