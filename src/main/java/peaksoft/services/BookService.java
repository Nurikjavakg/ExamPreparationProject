package peaksoft.services;

import peaksoft.entities.Author;
import peaksoft.entities.Book;

public interface BookService {
    Book saveBook(Book book,Long authorId);  //(Book сакталып жатканда кандайдыр бир авторго тиешелуу болуп сакталуусу керек)
    String updateBookAuthor(Long bookId, Author author);
    void getBookAndPublisherByBookId(Long bookId); //(Бир Id ге тиешелуу book тун маалыматтары жана ага тиешелуу издательствосу чыксын)
    String deleteBookByAuthorId(Long authorId);
}
