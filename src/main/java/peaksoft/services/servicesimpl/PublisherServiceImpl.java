package peaksoft.services.servicesimpl;

import peaksoft.entities.Publisher;
import peaksoft.repastitories.PublisherRepo;
import peaksoft.repastitories.repasitoriesimpl.PublisherRepoImpl;
import peaksoft.services.PublisherService;

import java.util.List;

public class PublisherServiceImpl implements PublisherService {
    PublisherRepo publisherRepo = new PublisherRepoImpl();
    @Override
    public Publisher SavePublisher(Publisher publisher) {
        return publisherRepo.SavePublisher(publisher);

    }

    @Override
    public Publisher getPublisherById(Long id) {
        return publisherRepo.getPublisherById(id);
    }

    @Override
    public List<Publisher> getAllPublishers() {
        return publisherRepo.getAllPublishers();

    }

    @Override
    public String updatePublisher(Long id,Publisher publisher) {
        publisherRepo.updatePublisher(id, publisher);
        return "Publisher is updated!";
    }

    @Override
    public String deletePublisherByName(String name) {
        publisherRepo.deletePublisherByName(name);
        return "Publisher is deleted!";
    }
}
