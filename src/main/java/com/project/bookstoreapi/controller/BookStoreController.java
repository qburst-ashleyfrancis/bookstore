package com.project.bookstoreapi.controller;

import com.project.bookstoreapi.dto.request.BookDetailsRequest;
import com.project.bookstoreapi.dto.response.BookDetailsResponse;
import com.project.bookstoreapi.dto.response.SearchBooksResponse;
import com.project.bookstoreapi.service.BookStoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
@Slf4j
public class BookStoreController {

    @Autowired
    BookStoreService service;

    /**
     * Save Book data.
     *
     * @param request the bookDetailsRequest
     * @return statusCode
     */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> save(@RequestBody BookDetailsRequest request) {
        log.debug("Executing save");
        service.save(request);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    /**
     * Get book details from ISBN.
     *
     * @param isbn the ISBN
     * @return BookDetails
     */
    @GetMapping(value = "/{isbn}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BookDetailsResponse> get(@PathVariable String isbn) {
        log.debug("Executing get with id :: {}", isbn);
        return ResponseEntity
                .ok()
                .body(service.findByIsbn(isbn));
    }

    /**
     * Update the book details based on bookId.
     *
     * @param bookId of the Book.
     * @param request bookDetailsRequest object.
     * @return Https status code
     */
    @PutMapping(value = "/{bookId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<HttpStatus> updateById(@PathVariable String bookId,
                                                 @RequestBody BookDetailsRequest request) {
        log.debug("Executing update for bookId :: {}", bookId);
        service.updateById(Long.valueOf(bookId), request);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    /**
     * Delete bookn details based on ISBN.
     *
     * @param isbn
     * @return
     */
    @DeleteMapping("/{isbn}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable String isbn) {
        log.debug("Executing delete for book's isbn :: {}", isbn);
        service.deleteByIsbn(isbn);
        return ResponseEntity.ok(HttpStatus.ACCEPTED);
    }

    /**
     * Search books from title.
     *
     * @param title the title
     * @return BookDetailsList
     */
    @GetMapping(value = "/search/{title}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SearchBooksResponse> getByTitle(@PathVariable String title) {
        log.debug("Executing search with title :: {}", title);
        return ResponseEntity
                .ok()
                .body(service.findByTitle(title));
    }

    /**
     * Get all books.
     *
     * @return BookDetailsList
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SearchBooksResponse> getAllBooks(@RequestParam(defaultValue = "0") Integer pageNo,
                                                   @RequestParam(defaultValue = "50") Integer pageSize,
                                                   @RequestParam(defaultValue = "bookId") String sortBy,
                                                   @RequestParam(defaultValue = "asc") String sortType) {
        log.debug("Executing get all books");
        return ResponseEntity
                .ok()
                .body(service.getAllBooks(pageNo, pageSize, sortBy, sortType));
    }



}
