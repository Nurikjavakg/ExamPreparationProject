package peaksoft.services.servicesimpl;

import peaksoft.entities.Book;
import peaksoft.entities.Reader;
import peaksoft.repastitories.ReaderRepo;
import peaksoft.repastitories.repasitoriesimpl.ReaderRepoImpl;
import peaksoft.services.ReaderService;

import java.util.Map;

public class ReaderServiceImpl implements ReaderService {
    ReaderRepo readerRepo = new ReaderRepoImpl();
    @Override
    public Reader saveReader(Reader reader) {
        return readerRepo.saveReader(reader);

    }

    @Override
    public String updateReader() {
        return null;
    }

    @Override
    public Map<Reader, Book> getReaderByBookId(Long id) {
        return readerRepo.getReaderByBookId(id);
    }


    @Override
    public String deleteReaderById() {
        return null;
    }

    @Override
    public Reader getReadersByAuthorId() {
        return null;
    }
}
