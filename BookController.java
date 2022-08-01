package com.assignment.book.Book_CRUD.controller;

import com.assignment.book.Book_CRUD.entity.Book;
import com.assignment.book.Book_CRUD.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/bookservice/books")
    public List<Book> getAllBooks() {
        List<Book> bookInfo = bookService.getAllBooks();
        return bookInfo;
    }

    @GetMapping("/bookservice/books/{id}")
    public Book getBook(@PathVariable("id") String bookId) {
        return bookService.getBook(bookId);
    }

    @PutMapping("bookservice/books")
    public String updateBook(@RequestBody Book book) {
        return bookService.updateBook(book);
    }

    @PostMapping("/bookservice/books")
    public Book addBook(@RequestBody Book book) {
        Book book1 = bookService.addBook(book);
        return book1;
    }

    @DeleteMapping("/bookservice/books/{id}")
    public String deleteBook(@PathVariable("id") String bookId) {
        return bookService.deleteBook(bookId);
    }



}
