package com.maverick.graphql.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.maverick.graphql.exception.DataNotFoundException;
import com.maverick.graphql.form.BookForm;
import com.maverick.graphql.model.BookModel;
import com.maverick.graphql.model.PersonModel;
import com.maverick.graphql.service.BookService;
import com.maverick.graphql.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookMutation implements GraphQLMutationResolver {

    private final BookService bookService;
    private final PersonService personService;

    @Autowired
    public BookMutation(BookService bookService, PersonService personService) {
        this.bookService = bookService;
        this.personService = personService;
    }

    public BookModel addBook(BookForm form) {
        PersonModel author = personService.getById(form.getAuthorId()).orElse(null);

        if (author == null) throw new DataNotFoundException("author record: not found");
        BookModel book = BookModel.builder()
                .author(author)
                .description(form.getDescription())
                .publisher(form.getPublisher())
                .releaseDate(Timestamp.valueOf(form.getReleaseDate().atStartOfDay()))
                .title(form.getTitle())
                .build();
        return bookService.save(book);
    }

    public BookModel updateBook(BookForm form, Long id) {
        BookModel book = bookService.getById(id);
        if (book == null) throw new DataNotFoundException("book record: not found");

        PersonModel author = personService.getById(form.getAuthorId()).orElse(null);
        if (author == null) throw new DataNotFoundException("author record: not found");
        book.setAuthor(author);
        book.setDescription(form.getDescription());
        book.setPublisher(form.getPublisher());
        book.setReleaseDate(Timestamp.valueOf(form.getReleaseDate().atStartOfDay()));
        book.setTitle(form.getTitle());
        return bookService.save(book);
    }

    public Map<String, String> deleteBook(Long id) {
        BookModel book = bookService.getById(id);
        if (book == null) throw new DataNotFoundException("book record: not found");

        bookService.delete(id);
        Map<String, String> ret = new HashMap<>();
        ret.put("message", "ok");

        return ret;
    }

}
