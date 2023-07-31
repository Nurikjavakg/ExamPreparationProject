package peaksoft.services.servicesimpl;

import peaksoft.entities.Author;
import peaksoft.repastitories.AuthorRepo;
import peaksoft.repastitories.repasitoriesimpl.AuthorRepoImpl;
import peaksoft.services.AuthorService;

public class AuthorServiceImpl implements AuthorService {
    AuthorRepo authorRepo = new AuthorRepoImpl();
    @Override
    public Author saveAuthor(Author author) {
        return authorRepo.saveAuthor(author);
    }

    @Override
    public String updateAuthor(Long id, Author author) {
      authorRepo.updateAuthor(id,author);
        return author+" is updated!";
    }

    @Override
    public Author getAuthorById(Long id) {
        return authorRepo.getAuthorById(id);
    }

    @Override
    public Author getAuthorsByPublisherId(Long publisherId) {
        return  authorRepo.getAuthorsByPublisherId(publisherId);

    }

    @Override
    public String deleteAuthorById() {
        return null;
    }

    @Override
    public String assignAuthorToPublisher(Long authorId,Long publisherId) {
        authorRepo.assignAuthorToPublisher(authorId,publisherId);
        return "Assigned Author to publisher";
    }
}
