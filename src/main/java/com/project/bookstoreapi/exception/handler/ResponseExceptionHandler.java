package com.project.bookstoreapi.exception.handler;


import com.project.bookstoreapi.exception.BookStoreException;
import com.project.bookstoreapi.exception.BookStoreServiceException;
import com.project.bookstoreapi.model.ErrorCodeResponse;
import com.project.bookstoreapi.model.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The ResponseExceptionHandler class.
 */
@ControllerAdvice
@Slf4j
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BookStoreException.class)
    protected ResponseEntity<Object> handle(final BookStoreException ex) {
        final String errorMessage = ex.getField() + ": " + ex.getMessage();
        final ErrorResponse errorResponse = new ErrorResponse(ex.getStatus(), errorMessage);
        return buildResponseEntity(errorResponse);
    }

    @ExceptionHandler(BookStoreServiceException.class)
    protected ResponseEntity<Object> handle(BookStoreServiceException e) {
        log.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorCodeResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
    }
    @ExceptionHandler(InvalidDataAccessResourceUsageException.class)
    protected ResponseEntity<Object> handle(InvalidDataAccessResourceUsageException e) {
        log.error(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorCodeResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()));
    }

    private ResponseEntity<Object> buildResponseEntity(final ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse, errorResponse.getStatus());
    }

}
