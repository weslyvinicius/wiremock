package com.academy.mockserver.feign;

import com.academy.mockserver.domain.Book;
import com.academy.mockserver.feign.request.BookApiRequest;
import com.academy.mockserver.feign.response.BookApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "bookApi", url = "${feign.client.hosts.bookApi}")
public interface BookApiClient {

    @PostMapping("/books")
    BookApiResponse createBook(BookApiRequest bookApiRequest);
}
