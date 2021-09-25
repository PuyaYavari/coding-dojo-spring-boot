package com.assignment.spring.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ModelError {
    @JsonProperty("Code")
    public int code;

    @JsonProperty("Message")
    public String message;

    public ModelError(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
