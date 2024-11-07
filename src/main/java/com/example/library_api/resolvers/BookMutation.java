package com.example.library_api.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.library_api.model.Book;
import com.example.library_api.service.BookService;
import com.example.library_api.service.AuthorService;
import org.springframework.stereotype.Component;

@Component
public class BookMutation implements GraphQLMutationResolver {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookMutation(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

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
