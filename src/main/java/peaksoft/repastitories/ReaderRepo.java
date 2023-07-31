package peaksoft.repastitories;

import peaksoft.entities.Reader;

public interface ReaderRepo {

 Reader saveReader();
 String updateReader();
 Reader getReaderByBookId();
 String deleteReaderById();
 Reader getReadersByAuthorId();


}
