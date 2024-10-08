package cibertec.edu.pe.T2_JV_JM.service;

import cibertec.edu.pe.T2_JV_JM.model.Book;

import java.util.List;

public interface IBookService {
    Book registerBook(Book Book);

    List<Book> findBooksWithStockGreaterThan(int stock);
}
