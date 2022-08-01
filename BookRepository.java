package com.assignment.book.Book_CRUD.repository;

import com.assignment.book.Book_CRUD.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {
}
