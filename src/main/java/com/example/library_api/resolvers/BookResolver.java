package com.example.library_api.resolvers;

import com.example.library_api.model.Book;
import com.example.library_api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class BookResolver {

    private final BookService bookService;

    @Autowired
    public BookResolver(BookService bookService) {
        this.bookService = bookService;
    }

    @QueryMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @QueryMapping
    public Optional<Book> getBook(Long id) {
        return bookService.getBookById(id);
    }
}
