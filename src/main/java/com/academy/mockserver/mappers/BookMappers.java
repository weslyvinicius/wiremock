package com.academy.mockserver.mappers;

import com.academy.mockserver.domain.Book;
import com.academy.mockserver.dto.BookRequest;
import com.academy.mockserver.dto.BookResponse;
import com.academy.mockserver.feign.request.BookApiRequest;
import com.academy.mockserver.feign.response.AuthorApiResponse;
import com.academy.mockserver.feign.response.BookApiResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookMappers {

    @Mapping( target = "author", source = "authorRequest")
    Book convertBookRequestToBook(BookRequest bookRequest);

    BookApiRequest convertBookToBookApiRequest(Book book);

    @Mapping( target = "id", source = "bookApiResponse.id")
    @Mapping( target = "author.id", source = "authorApiResponse.id")
    @Mapping( target = "author.authorName", source = "authorApiResponse.authorName")
    Book createBookWithBookApiAndAuthorApi(BookApiResponse bookApiResponse, AuthorApiResponse authorApiResponse);

    @Mapping( target = "authorResponse", source = "author")
    BookResponse converteBookToBookResponse(Book book);


}
