package com.academy.mockserver.mocks;

import com.academy.mockserver.feign.response.AuthorApiResponse;
import com.academy.mockserver.feign.response.BookApiResponse;
import com.academy.mockserver.util.TestConstants;
import com.academy.mockserver.util.TestUtils;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

public class AuthorMocks {

    public static void setupMockAuthorResponse(WireMockServer mockService) throws IOException {

        AuthorApiResponse authorApiResponse = TestUtils.mapperReader(TestConstants.AUTHOR_RESPONSE, AuthorApiResponse.class);


        mockService.stubFor(WireMock.post(WireMock.urlEqualTo("/authors"))
                .willReturn(WireMock.aResponse()
                        .withStatus(HttpStatus.OK.value())
                        .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                        .withBody(TestUtils.writeValueAsString(authorApiResponse))));
    }
}
