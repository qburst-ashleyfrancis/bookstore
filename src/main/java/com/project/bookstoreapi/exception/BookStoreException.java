package com.project.bookstoreapi.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class BookStoreException extends RuntimeException {

    private final HttpStatus status;
    private final String field;
    private final String message;

    public BookStoreException(final HttpStatus status, final String field, final String message) {
        super(message);
        this.status = status;
        this.message = message;
        this.field = field;

    }

    public BookStoreException(final HttpStatus status, final String field, final String message, final Throwable cause) {
        super(message, cause);
        this.status = status;
        this.message = message;
        this.field = field;
    }
}
