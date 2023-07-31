package peaksoft.repastitories.repasitoriesimpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.DataBaseConfig;
import peaksoft.entities.Author;
import peaksoft.entities.Publisher;
import peaksoft.repastitories.AuthorRepo;

public class AuthorRepoImpl  implements AuthorRepo {
    private final EntityManagerFactory entityManager = DataBaseConfig.getEntityManager();
    @Override
    public Author saveAuthor(Author author) {
       EntityManager entityManagerFactory = entityManager.createEntityManager();
       entityManagerFactory.getTransaction().begin();
       entityManagerFactory.persist(author);
       entityManagerFactory.getTransaction().commit();
       entityManagerFactory.close();
        return author;
    }

    @Override
    public String updateAuthor(Long id,Author author) {
        EntityManager entityManagerFactory = entityManager.createEntityManager();
        entityManagerFactory.getTransaction().begin();
        Author author1 = entityManagerFactory.find(Author.class,id);
        author1.setFirst_name(author.getFirst_name());
        author1.setLast_name(author.getLast_name());
        author1.setGender(author.getGender());
        author1.setEmail(author.getEmail());
        entityManagerFactory.getTransaction().commit();
        entityManagerFactory.close();
        return null;
    }

    @Override
    public Author getAuthorById(Long id) {
        EntityManager entityManager1 = entityManager.createEntityManager();
        Author author=entityManager1.find(Author.class,id);
        author.getPublishers().size();
        author.getBookList().size();
        entityManager1.getTransaction().begin();
        entityManager1.getTransaction().commit();
        entityManager1.close();

        return author;
    }

    @Override
    public Author getAuthorsByPublisherId(Long publisherId) {
        EntityManager entityManager1 = entityManager.createEntityManager();
        entityManager1.getTransaction().begin();
        Author author = entityManager1.createQuery("select a from Author a join a.publishers p where p.id= :publisherId",Author.class).setParameter("publisherId",publisherId).getSingleResult();
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return author;
    }

    @Override
    public String deleteAuthorById() {
        return null;
    }

    @Override
    public String assignAuthorToPublisher(Long authorId,Long publisherId) {
        EntityManager entityManager1 = entityManager.createEntityManager();
        entityManager1.getTransaction().begin();
        Author author = entityManager1.find(Author.class,authorId);
        Publisher publisher = entityManager1.find(Publisher.class,publisherId);
        author.getPublishers().add(publisher);
        publisher.getAuthors().add(author);
        entityManager1.getTransaction().commit();
        entityManager1.close();
        return "Assigned Author to publisher!";
    }
}
