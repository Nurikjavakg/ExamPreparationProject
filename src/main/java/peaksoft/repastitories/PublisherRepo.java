package peaksoft.repastitories;

import peaksoft.entities.Publisher;

import java.util.List;

public interface PublisherRepo {
    Publisher SavePublisher(Publisher publisher);  // деген метод тузуп, сакталган Publisher ди кайтаруу керек.
    Publisher getPublisherById(Long id);
    List<Publisher> getAllPublishers();  //(аты боюнча сорттоп чыгаруу)
    String updatePublisher(Long id,Publisher publisher);
    String deletePublisherByName(String name); // (издательствону очургондо, ага тиешелуу китептер жана авторлор  очпошу керек), методдорун тузуп, ишке ашыруу.
}
