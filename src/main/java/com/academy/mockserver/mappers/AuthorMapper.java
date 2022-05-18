package com.academy.mockserver.mappers;

import com.academy.mockserver.domain.Author;
import com.academy.mockserver.feign.request.AuthorApiRequest;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface AuthorMapper {

    AuthorApiRequest convertBookToAuthorApiRequest(Author author);
}
