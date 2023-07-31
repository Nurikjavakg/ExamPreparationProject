package peaksoft;

import peaksoft.config.DataBaseConfig;
import peaksoft.entities.Author;
import peaksoft.entities.Book;
import peaksoft.entities.Publisher;
import peaksoft.entities.Reader;
import peaksoft.enums.Genre;
import peaksoft.services.AuthorService;
import peaksoft.services.BookService;
import peaksoft.services.PublisherService;
import peaksoft.services.ReaderService;
import peaksoft.services.servicesimpl.AuthorServiceImpl;
import peaksoft.services.servicesimpl.BookServiceImpl;
import peaksoft.services.servicesimpl.PublisherServiceImpl;
import peaksoft.services.servicesimpl.ReaderServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

import static peaksoft.enums.Gender.MALE;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ){
       // DataBaseConfig.getEntityManager();

        PublisherService publisherService = new PublisherServiceImpl();
        AuthorService authorService = new AuthorServiceImpl();
        BookService bookService = new BookServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();

/**publisher**/
        // System.out.println(publisherService.SavePublisher(new Publisher("Lamburg", "Britch.Str 32")));
//        publisherService.getAllPublishers().forEach(n -> {
//            System.out.println(n.getId());
//            System.out.println(n.getName());
//            System.out.println(n.getAddress());});
   //     System.out.println(publisherService.updatePublisher(4L, new Publisher("NYCBook", "Wall.Str 35")));
//        System.out.println(publisherService.getPublisherById(1L));
 //       System.out.println(publisherService.deletePublisherByName("Lamburg"));
/**AUTHOR**/
//        authorService.saveAuthor(new Author("Grand","Cardon","cardon@gmail.com", LocalDate.of(1963,4,1),"America",MALE));
//        authorService.updateAuthor(3L,new Author("Brain","Tracy","brain@gmail.com", LocalDate.of(1953,11,4),"America",MALE));
//        System.out.println(authorService.getAuthorById(1L));
//        System.out.println(authorService.assignAuthorToPublisher(1L, 4L));
//        System.out.println(authorService.getAuthorsByPublisherId(1L));

/**book**/

//            Author author = new Author("Robert","Kiosaki","rober@gmail.com", LocalDate.of(1953,11,4),"America",MALE);
//            Publisher publisher = new Publisher("Stutgart","Baum.Str a34");
//            Book book = new Book("Rich dad poor dad","America",LocalDate.of(2018,3,1), BigDecimal.valueOf(5000), Genre.DETECTIVE);
//            book.setAuthor(author);
//            book.setPublisher(publisher);
       //     bookService.saveBook(new Book("Jamila","kg",LocalDate.of(2018,3,1), BigDecimal.valueOf(5000), Genre.DETECTIVE),4L);

//        System.out.println(bookService.updateBookAuthor(8L, new Author("Grand", "Cardon", "cardon@gmail.com", LocalDate.of(1963, 4, 1), "America", MALE)));
      //    bookService.getBookAndPublisherByBookId(4L);
/**reader*/

//        Reader reader = new Reader("James Arthur",34,"james@gmail.com");
//        reader.setBook(new Book("Ne sdavaisa","kg",LocalDate.of(2018,3,1), BigDecimal.valueOf(5000), Genre.DETECTIVE));
//        readerService.saveReader(reader);
      //
        //
        //
        //  System.out.println(readerService.getReaderByBookId(1L));
        bookService.deleteBookByAuthorId(8L);
        System.out.println("hello world");

    }
}
