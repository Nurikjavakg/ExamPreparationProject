package peaksoft.repastitories;

import peaksoft.entities.Book;
import peaksoft.entities.Reader;

import java.util.Map;

public interface ReaderRepo {

 Reader saveReader(Reader reader);
 String updateReader();
 Map<Reader,Book> getReaderByBookId(Book id);
 String deleteReaderById();
 Reader getReadersByAuthorId();


}
