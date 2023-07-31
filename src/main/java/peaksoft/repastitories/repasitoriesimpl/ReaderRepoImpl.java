package peaksoft.repastitories.repasitoriesimpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.DataBaseConfig;
import peaksoft.entities.Book;
import peaksoft.entities.Reader;
import peaksoft.repastitories.ReaderRepo;

import java.util.HashMap;
import java.util.Map;

public class ReaderRepoImpl implements ReaderRepo {
    private final EntityManagerFactory entityManagerFactory = DataBaseConfig.getEntityManager();
    @Override
    public Reader saveReader(Reader reader) {
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        entityManager1.getTransaction().begin();
        entityManager1.persist(reader);
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return reader;
    }

    @Override
    public String updateReader() {
        return null;
    }

    @Override
    public Map<Reader,Book> getReaderByBookId(Book id) {
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        entityManager1.getTransaction().begin();
        Map<Reader,Book>map = new HashMap<>();
        Reader reader = entityManager1.find(Reader.class,id);

        reader.getBook();

        entityManager1.getTransaction().commit();
        entityManager1.close();
        return null;
    }

    @Override
    public String deleteReaderById() {
        return null;
    }

    @Override
    public Reader getReadersByAuthorId() {
        return null;
    }
}
