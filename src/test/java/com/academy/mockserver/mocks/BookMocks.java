package com.academy.mockserver.mocks;

import com.academy.mockserver.dto.BookRequest;
import com.academy.mockserver.feign.request.BookApiRequest;
import com.academy.mockserver.feign.response.BookApiResponse;
import com.academy.mockserver.util.TestConstants;
import com.academy.mockserver.util.TestUtils;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

public class BookMocks {

    public static void setupMockBooksResponse(WireMockServer mockService) throws IOException {

        BookApiResponse bookApiResponse = TestUtils.mapperReader(TestConstants.BOOK_RESPONSE, BookApiResponse.class);


        mockService.stubFor(WireMock.post(WireMock.urlEqualTo("/books"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(TestUtils.writeValueAsString(bookApiResponse))));
    }
}
