package cibertec.edu.pe.T2_JV_JM.controller;

import cibertec.edu.pe.T2_JV_JM.model.Book;
import cibertec.edu.pe.T2_JV_JM.service.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/books")
public class BookController {
    private final IBookService bookService;

    // Endpoint to register a new book
    @PostMapping
    public ResponseEntity<Book> registerBook(@RequestBody Book book) {
        Book savedBook = bookService.registerBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }

    // Endpoint to get books with stock greater than a specified value
    @GetMapping("/stock/{stock}")
    public ResponseEntity<List<Book>> getBooksByStock(@PathVariable int stock) {
        List<Book> books = bookService.findBooksWithStockGreaterThan(stock);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}
