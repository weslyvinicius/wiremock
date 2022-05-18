package com.academy.mockserver.feign.request;


public class BookApiRequest {

    private String bookName;

    private String yearEdition;

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
