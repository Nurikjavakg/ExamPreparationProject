package peaksoft.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "readers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "reader_gen")
    @SequenceGenerator(
                     name = "reader_gen",
                     sequenceName = "reader_seq",
                     allocationSize = 1
    )
    private Long id;
    private String name;
    private int age;
    private String email;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_id")
    private Book book;

    public Reader(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }
}

