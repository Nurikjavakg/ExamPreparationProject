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
    public Book saveBook(Book book,Long authorId) {
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        entityManager1.getTransaction().begin();
        Author author = entityManager1.find(Author.class,authorId);
        entityManager1.persist(book);
        book.setAuthor(author);
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
        entityManager1.getTransaction().commit();
        entityManager1.close();

        return author + " is updated!";
    }

    @Override
    public void getBookAndPublisherByBookId(Long bookId) {
        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
        entityManager1.getTransaction().begin();
        Book book = entityManager1.createQuery("select b from Book b join Publisher p on b.publisher.id = p.id where b.id=:bookId", Book.class).setParameter("bookId", bookId).getSingleResult();
        System.out.println(book);
        System.out.println(book.getPublisher());
        entityManager1.getTransaction().commit();

        entityManager1.close();
    }

    @Override
    public String deleteBookByAuthorId(Long authorId) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        // Check if there are any books associated with the author
        List<Book> books = entityManager.createQuery("SELECT b FROM Book b WHERE b.author.id = :authorId", Book.class)
                .setParameter("authorId", authorId)
                .getResultList();

        if (!books.isEmpty()) {
            System.out.println("Cannot delete the author. There are books associated with this author.");
        } else {
            // No books found, delete the author
            Author author = entityManager.find(Author.class, authorId);
            if (author != null) {
                entityManager.remove(author);
                entityManager.getTransaction().commit();
                System.out.println("Author with ID " + authorId + " has been deleted.");
            } else {
                System.out.println("Author with ID " + authorId + " not found.");
            }
        }

        entityManager.close();

//        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
//        entityManager1.getTransaction().begin();
//        Book book = entityManager1.createQuery("select b from Book b join Author a on b.author.id=a.id where b.id=:authorId", Book.class).setParameter("authorId", authorId).getSingleResult();
//        entityManager1.remove(book);
//        entityManager1.getTransaction().commit();
//        entityManager1.close();
        return "is deleted!";
    }
}
