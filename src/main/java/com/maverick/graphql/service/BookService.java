package com.maverick.graphql.service;

import com.maverick.graphql.model.BookModel;
import com.maverick.graphql.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookModel save(BookModel book) {
        return bookRepository.save(book);
    }

    public List<BookModel> getAll() {
        return bookRepository.findAll();
    }

    public List<BookModel> getAllByAuthor(String name) {
        return bookRepository.findAllByAuthor(name);
    }

    public BookModel getById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void delete(Long id) {
        bookRepository.softDelete(id);
    }

}
