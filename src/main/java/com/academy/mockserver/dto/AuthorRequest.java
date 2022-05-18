package com.academy.mockserver.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorRequest {

    @JsonProperty("authorName")
    private String authorName;

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
