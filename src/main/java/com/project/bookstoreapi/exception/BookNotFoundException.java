package com.project.bookstoreapi.exception;

public class BookNotFoundException extends BookStoreServiceException {

    private static final String BOOK_NOT_FOUND = "Book is not available";
    public BookNotFoundException( ) {
        super(String.format(BOOK_NOT_FOUND));
    }
}
