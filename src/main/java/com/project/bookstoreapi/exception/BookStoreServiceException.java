package com.project.bookstoreapi.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BookStoreServiceException extends RuntimeException {

    BookStoreServiceException(String message) {
        super(message);
    }

}
