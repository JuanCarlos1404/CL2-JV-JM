package cibertec.edu.pe.T2_JV_JM.service.impl;

import cibertec.edu.pe.T2_JV_JM.model.Book;
import cibertec.edu.pe.T2_JV_JM.repository.BookRepository;
import cibertec.edu.pe.T2_JV_JM.service.IBookService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BooKService implements IBookService {

    private final BookRepository bookRepository;

    @Transactional
    @Override
    public Book registerBook(Book Book) {
        return bookRepository.save(Book);
    }

    @Transactional
    @Override
    public List<Book> findBooksWithStockGreaterThan(int stock) {
        return bookRepository.findByStockGreaterThan(stock);
    }
}
