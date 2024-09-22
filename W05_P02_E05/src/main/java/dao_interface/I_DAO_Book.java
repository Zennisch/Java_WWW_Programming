package dao_interface;

import model.Book;

import java.util.List;

public interface I_DAO_Book {

    List<Book> getAllBooks();
    Book getBook(int id);

}
