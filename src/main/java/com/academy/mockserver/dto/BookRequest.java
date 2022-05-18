package com.academy.mockserver.dto;

import com.fasterxml.jackson.annotation.JsonProperty;


public class BookRequest {

    @JsonProperty("bookName")
    private String bookName;

    @JsonProperty("yearEdition")
    private String yearEdition;

    @JsonProperty("authorRequest")
    private AuthorRequest authorRequest;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getYearEdition() {
        return yearEdition;
    }

    public void setYearEdition(String yearEdition) {
        this.yearEdition = yearEdition;
    }

    public AuthorRequest getAuthorRequest() {
        return authorRequest;
    }

    public void setAuthorRequest(AuthorRequest authorRequest) {
        this.authorRequest = authorRequest;
    }
}
