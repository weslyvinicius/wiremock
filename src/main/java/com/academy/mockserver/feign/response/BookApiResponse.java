package com.academy.mockserver.feign.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BookApiResponse {

    @JsonProperty("id")
    private Long  id;

    @JsonProperty("bookName")
    private String bookName;

    @JsonProperty("yearEdition")
    private String yearEdition;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
