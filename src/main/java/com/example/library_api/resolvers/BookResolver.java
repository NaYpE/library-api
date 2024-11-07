package com.example.library_api.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.library_api.model.Book;
import com.example.library_api.service.BookService;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

@Component
public class BookResolver implements GraphQLQueryResolver {

    private final BookService bookService;

    public BookResolver(BookService bookService) {
        this.bookService = bookService;
    }

    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    public Optional<Book> getBook(Long id) {
        return bookService.getBookById(id);
    }

}
