package com.example.library_api.resolvers;

import com.example.library_api.model.Book;
import com.example.library_api.service.BookService;
import com.example.library_api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookMutation {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookMutation(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @MutationMapping
    public Book createBook(String title, Long authorId) {
        return authorService.getAuthorById(authorId)
                .map(author -> {
                    Book book = new Book();
                    book.setTitle(title);
                    book.setAuthor(author);
                    return bookService.createBook(book);
                }).orElseThrow(() -> new RuntimeException("Author not found"));
    }
}
