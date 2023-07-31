package peaksoft.services;

import peaksoft.entities.Book;
import peaksoft.entities.Reader;

import java.util.Map;

public interface ReaderService {
    Reader saveReader(Reader reader);
    String updateReader();
    Map<Reader,Book> getReaderByBookId(Long id);
    String deleteReaderById();
    Reader getReadersByAuthorId();


}
