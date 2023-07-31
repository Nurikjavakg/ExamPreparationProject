package peaksoft.repastitories;

import peaksoft.entities.Author;
import peaksoft.entities.Book;

public interface BookRepo {
    Book saveBook(Book book);  //(Book сакталып жатканда кандайдыр бир авторго тиешелуу болуп сакталуусу керек)
    String updateBookAuthor(Long bookId, Author author);
    void getBookAndPublisherByBookId(Long bookId); //(Бир Id ге тиешелуу book тун маалыматтары жана ага тиешелуу издательствосу чыксын)
    String deleteBookByAuthorId();
}
