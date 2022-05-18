package com.academy.mockserver.feign.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthorApiResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("authorName")
    private String authorName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
