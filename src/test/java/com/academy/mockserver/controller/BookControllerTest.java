package com.academy.mockserver.controller;

import com.academy.mockserver.config.WireMockConfig;
import com.academy.mockserver.dto.BookRequest;
import com.academy.mockserver.mocks.AuthorMocks;
import com.academy.mockserver.mocks.BookMocks;
import com.academy.mockserver.util.TestConstants;
import com.academy.mockserver.util.TestUtils;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
@ContextConfiguration(classes = {WireMockConfig.class})
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WireMockServer mockBooksService;


    @BeforeEach
    void setUp() throws IOException {
        BookMocks.setupMockBooksResponse(mockBooksService);
        AuthorMocks.setupMockAuthorResponse(mockBooksService);
    }

    @Test
    void createBook() throws Exception {

        BookRequest bookRequest = TestUtils.mapperReader(TestConstants.BOOK_REQUEST, BookRequest.class);

        mockMvc.perform(MockMvcRequestBuilders.post("/books")
                        .content(TestUtils.writeValueAsString(bookRequest))

                        .contentType(MediaType.APPLICATION_JSON)
                        .characterEncoding(StandardCharsets.UTF_8)
                )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(123)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.authorResponse.id", Matchers.is(987)));

    }
}