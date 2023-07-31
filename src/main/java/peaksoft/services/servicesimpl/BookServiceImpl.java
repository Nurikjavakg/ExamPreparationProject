package peaksoft.services.servicesimpl;

import peaksoft.entities.Author;
import peaksoft.entities.Book;
import peaksoft.repastitories.BookRepo;
import peaksoft.repastitories.repasitoriesimpl.BookRepoImpl;
import peaksoft.services.BookService;

public class BookServiceImpl implements BookService {
    BookRepo bookRepo = new BookRepoImpl();

    @Override
    public Book saveBook(Book book,Long authorId) {
        return bookRepo.saveBook(book,authorId);

    }

    @Override
    public String updateBookAuthor(Long bookId, Author author) {
        bookRepo.updateBookAuthor(bookId,author);
        return "is updated!";
    }

    @Override
    public void getBookAndPublisherByBookId(Long bookId) {
       bookRepo.getBookAndPublisherByBookId(bookId);
    }

    @Override
    public String deleteBookByAuthorId(Long authorId) {
        bookRepo.deleteBookByAuthorId(authorId);
        return authorId+" is deleted!";
    }
}
