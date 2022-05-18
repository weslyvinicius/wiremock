package com.academy.mockserver.controller;

import com.academy.mockserver.domain.Book;
import com.academy.mockserver.dto.BookRequest;
import com.academy.mockserver.dto.BookResponse;
import com.academy.mockserver.mappers.BookMappers;
import com.academy.mockserver.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final BookMappers bookMappers;

    public BookController(BookService bookService, BookMappers bookMappers) {
        this.bookService = bookService;
        this.bookMappers = bookMappers;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public BookResponse createBook(@RequestBody BookRequest bookRequest){

        Book book = bookService.createBookAndAuthor(bookMappers.convertBookRequestToBook(bookRequest));

        return bookMappers.converteBookToBookResponse(book);

    }

}
