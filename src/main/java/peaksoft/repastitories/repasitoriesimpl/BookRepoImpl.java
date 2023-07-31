package peaksoft.repastitories.repasitoriesimpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.DataBaseConfig;
import peaksoft.entities.Author;
import peaksoft.entities.Book;
import peaksoft.entities.Publisher;
import peaksoft.repastitories.BookRepo;

import java.util.List;

public class BookRepoImpl implements BookRepo {
    private final EntityManagerFactory entityManagerFactory = DataBaseConfig.getEntityManager();

    @Override
    public Book saveBook(Book book) {
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        entityManager1.getTransaction().begin();
        entityManager1.persist(book);
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return book;
    }

    @Override
    public String updateBookAuthor(Long bookId, Author author) {
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        entityManager1.getTransaction().begin();
        Book book = entityManager1.find(Book.class, bookId);
        book.setAuthor(author);
        entityManager1.persist(book);
        entityManager1.getTransaction().commit();
        entityManager1.close();

        return author + " is updated!";
    }

    @Override
    public void getBookAndPublisherByBookId(Long bookId) {
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();

        entityManager1.getTransaction().begin();
//        Book book1 = entityManager1.find(Book.class, bookId);
        Book book = entityManager1.createQuery("select b from Book b join Publisher p on b.publisher_id=p.id where b.id=:bookId", Book.class).setParameter("bookId", bookId).getSingleResult();
//        List<Publisher> publishers = entityManager1.createQuery("SELECT p FROM Publisher p JOIN FETCH p.bookList WHERE p.id = :publisherId", Publisher.class)
//                .setParameter("publisherId", bookId).getResultList();
     //   System.out.println(book1);
        entityManager1.getTransaction().commit();

        entityManager1.close();
        //  System.out.println(publishers);
    }

    @Override
    public String deleteBookByAuthorId() {
        return null;
    }
}
