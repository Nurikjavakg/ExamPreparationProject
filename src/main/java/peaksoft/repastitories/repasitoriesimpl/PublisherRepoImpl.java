package peaksoft.repastitories.repasitoriesimpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import peaksoft.config.DataBaseConfig;
import peaksoft.entities.Publisher;
import peaksoft.repastitories.PublisherRepo;

import java.util.List;

public class PublisherRepoImpl implements PublisherRepo {
    private final EntityManagerFactory entityManagerFactory = DataBaseConfig.getEntityManager();
    @Override
    public Publisher SavePublisher(Publisher publisher) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public Publisher getPublisherById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.find(Publisher.class,id);
        publisher.getBookList().size();
        publisher.getAuthors().size();
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher;
    }

    @Override
    public List<Publisher> getAllPublishers() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Publisher> publishers = entityManager.createQuery("select p from Publisher p order by p.name",Publisher.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return publishers;
    }

    @Override
    public String updatePublisher(Long id,Publisher publisher) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Publisher publisher1 = entityManager.find(Publisher.class,id);
        publisher1.setName(publisher.getName());
        publisher1.setAuthors(publisher.getAuthors());
        publisher1.setBookList(publisher.getBookList());
        publisher1.setAddress(publisher.getAddress());
        entityManager.persist(publisher1);
        entityManager.getTransaction().commit();
        entityManager.close();
        return publisher+" is updated!";
    }

    @Override
    public String deletePublisherByName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Publisher publisher = entityManager.createQuery("select p from Publisher p where p.name= :name",Publisher.class).setParameter("name",name).getSingleResult();
        entityManager.remove(publisher);
        entityManager.getTransaction().commit();
        entityManager.close();
        return name+" is deleted!";
    }
}
