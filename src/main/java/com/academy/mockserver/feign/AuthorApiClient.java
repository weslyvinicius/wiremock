package com.academy.mockserver.feign;

import com.academy.mockserver.domain.Author;
import com.academy.mockserver.feign.request.AuthorApiRequest;
import com.academy.mockserver.feign.response.AuthorApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(value = "authorAPi", url = "${feign.client.hosts.authorApi}")
public interface AuthorApiClient {

    @PostMapping("/authors")
    AuthorApiResponse createBook(AuthorApiRequest authorApiRequest);

}
