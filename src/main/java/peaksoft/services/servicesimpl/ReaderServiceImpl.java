package peaksoft.services.servicesimpl;

import peaksoft.entities.Reader;
import peaksoft.repastitories.ReaderRepo;
import peaksoft.repastitories.repasitoriesimpl.ReaderRepoImpl;
import peaksoft.services.ReaderService;

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
    public Reader getReaderByBookId() {
        return null;
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
