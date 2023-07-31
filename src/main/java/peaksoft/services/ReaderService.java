package peaksoft.services;

import peaksoft.entities.Reader;

public interface ReaderService {
    Reader saveReader(Reader reader);
    String updateReader();
    Reader getReaderByBookId();
    String deleteReaderById();
    Reader getReadersByAuthorId();


}
