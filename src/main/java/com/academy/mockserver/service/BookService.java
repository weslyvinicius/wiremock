package com.academy.mockserver.service;

import com.academy.mockserver.domain.Book;
import com.academy.mockserver.feign.AuthorApiClient;
import com.academy.mockserver.feign.BookApiClient;
import com.academy.mockserver.feign.response.AuthorApiResponse;
import com.academy.mockserver.feign.response.BookApiResponse;
import com.academy.mockserver.mappers.AuthorMapper;
import com.academy.mockserver.mappers.BookMappers;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookApiClient bookApiClient;

    private final AuthorApiClient authorApiClient;

    private final AuthorMapper authorMapper;

    private final BookMappers bookMappers;



    public BookService(BookApiClient bookApiClient, AuthorApiClient authorApiClient, AuthorMapper authorMapper, BookMappers bookMappers) {
        this.bookApiClient = bookApiClient;
        this.authorApiClient = authorApiClient;
        this.authorMapper = authorMapper;
        this.bookMappers = bookMappers;
    }


    public Book createBookAndAuthor(Book book){

        BookApiResponse bookApiResponse = bookApiClient.createBook(bookMappers.convertBookToBookApiRequest(book));

        AuthorApiResponse authorApiResponse = authorApiClient.createBook(authorMapper.convertBookToAuthorApiRequest(book.getAuthor()));


        return bookMappers.createBookWithBookApiAndAuthorApi(bookApiResponse, authorApiResponse);
    }
}
