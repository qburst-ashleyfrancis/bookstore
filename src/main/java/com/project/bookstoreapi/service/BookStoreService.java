package com.project.bookstoreapi.service;

import com.project.bookstoreapi.dto.request.BookDetailsRequest;
import com.project.bookstoreapi.dto.response.BookDetailsResponse;
import com.project.bookstoreapi.dto.response.SearchBooksResponse;
import org.springframework.stereotype.Service;

@Service
public interface BookStoreService {
    void save(BookDetailsRequest request);

    BookDetailsResponse findByIsbn(String isbn);

    void updateById(Long bookId, BookDetailsRequest request);

    void deleteByIsbn(String isbn);

    SearchBooksResponse findByTitle(String title);

    SearchBooksResponse getAllBooks(Integer pageNo, Integer pageSize, String sortBy,
                                    String sortType);
}
