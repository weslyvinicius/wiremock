package com.academy.mockserver.domain;

public class Book {

    private Long  id;

    private String bookName;

    private String yearEdition;

    private Author author;

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
