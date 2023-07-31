package peaksoft.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "readers")
@Getter
@Setter
@NoArgsConstructor
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
    @OneToOne
    @JoinColumn(name = "book_id")
    private Book book;

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

