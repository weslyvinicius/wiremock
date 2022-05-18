package com.academy.mockserver.dto;


public class BookResponse {

    private Long id;

    private String bookName;

    private String yearEdition;

    private AuthorResponse authorResponse;

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

    public AuthorResponse getAuthorResponse() {
        return authorResponse;
    }

    public void setAuthorResponse(AuthorResponse authorResponse) {
        this.authorResponse = authorResponse;
    }
}
