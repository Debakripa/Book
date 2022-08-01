package com.assignment.book.Book_CRUD.service;

import com.assignment.book.Book_CRUD.entity.Book;
import com.assignment.book.Book_CRUD.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }


    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBook(String bookId) {

        try {
            return bookRepository.findById(bookId).get();
        }
        catch (Exception e) {

        }
        return null;
    }

    public String deleteBook(String bookId) {

        try {

            //  bookRepository.findById(bookId).get() -> fetches the book with the matching bookId
            // bookRepository.delete(--fetched book--) -> deletes the book fetched

            bookRepository.delete(bookRepository.findById(bookId).get());

            return "Delete Successful";

        } catch (Exception e) {
            return "Delete Unsuccessful";
        }

    }

    public String  updateBook(Book book) {

        Optional<Book> book1 = bookRepository.findById(book.getBook_id());

        if (book1.isEmpty()) {
            return "Book not found.";
        }

        book1.get().setAuthor(book.getAuthor());
        book1.get().setCategory(book.getCategory());
        book1.get().setName(book.getName());
        book1.get().setPages(book.getPages());
        book1.get().setPrice(book.getPrice());
        book1.get().setPublication(book.getPublication());

        bookRepository.save(book1.get());

        return "Book details have been updated successfully.";
    }
}
