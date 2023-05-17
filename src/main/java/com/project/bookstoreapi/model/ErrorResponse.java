package com.project.bookstoreapi.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Data()
public class ErrorResponse {

    private HttpStatus status;
    private List<String> errors;

    public ErrorResponse(final HttpStatus status, final List<String> errors) {
        super();
        this.status = status;
        this.errors = errors;
    }

    public ErrorResponse(final HttpStatus status, final String error) {
        super();
        this.status = status;
        errors = Arrays.asList(error);
    }
}
