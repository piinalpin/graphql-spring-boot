package com.maverick.graphql.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.maverick.graphql.exception.DataNotFoundException;
import com.maverick.graphql.model.BookModel;
import com.maverick.graphql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookResolver implements GraphQLQueryResolver {

    private final BookService bookService;

    @Autowired
    public BookResolver(BookService bookService) {
        this.bookService = bookService;
    }

    public List<BookModel> getAllBook() {
        return bookService.getAll();
    }

    public List<BookModel> getAllBookByAuthor(final String author) {
        return bookService.getAllByAuthor(author);
    }

    public BookModel getBookById(final Long id) {
        BookModel book = bookService.getById(id);
        if (book == null) throw new DataNotFoundException("book record: not found");
        return book;
    }

}
