package peaksoft.repastitories;

import peaksoft.entities.Author;

public interface AuthorRepo {
    Author saveAuthor(Author author);
    String updateAuthor(Long id,Author author);
    Author getAuthorById(Long id);
    Author getAuthorsByPublisherId(Long publisherId); //(тиешелуу издательствонун авторлорун чыгарып беруу)
    String deleteAuthorById(); //(автор очкондо, авторго тиешелуу издательство очпошу керек, китептер очуш керек)
    String assignAuthorToPublisher(Long authorId,Long publisherId);  //(авторду издательствого кошуп коюу(назначить)).
}
