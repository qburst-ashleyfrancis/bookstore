package com.project.bookstoreapi.service.impl;

import com.project.bookstoreapi.dto.request.BookDetailsRequest;
import com.project.bookstoreapi.dto.response.BookDetailsResponse;
import com.project.bookstoreapi.dto.response.SearchBooksResponse;
import com.project.bookstoreapi.exception.BookNotFoundException;
import com.project.bookstoreapi.exception.BookStoreException;
import com.project.bookstoreapi.model.BookEntity;
import com.project.bookstoreapi.repository.BookStoreRepository;
import com.project.bookstoreapi.service.BookStoreService;
import com.project.bookstoreapi.service.mapper.BookStoreMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BookStoreServiceImpl implements BookStoreService {
    @Autowired
    BookStoreMapper mapper;

    @Autowired
    BookStoreRepository repository;


    /**
     * Method to save book.
     *
     * @param request
     * @return
     */
    @Override
    public void save(BookDetailsRequest request) {
        log.debug("save book");
        BookEntity entity = mapper.toEntity(request);
        try {
            repository.save(entity);
        } catch (Exception e) {
            throw new BookStoreException(HttpStatus.INTERNAL_SERVER_ERROR, "BookStore Table", e.getMessage());
        }
    }

    /**
     * Method to find book by ISBN.
     *
     * @param isbn
     * @return
     */
    @Override
    public BookDetailsResponse findByIsbn(String isbn) {
        log.debug("findByIsbn for bookDetails");
        final Optional<BookEntity> bookEntity =
                Optional.ofNullable(repository.findByIsbn(isbn));
        if (bookEntity.isPresent()) {
            return mapper.toResponse(bookEntity.get());
        } else {
            throw new BookNotFoundException();
        }
    }

    /**
     * Method to update book by bookId.
     *
     * @param bookId
     * @param request
     * @return
     */
    @Override
    public void updateById(Long bookId, BookDetailsRequest request) {
        log.debug("update book details");
        final Optional<BookEntity> bookEntity =
                Optional.ofNullable(repository.findByBookId(bookId));
        if (bookEntity.isPresent()) {
             mapper.patch(request,bookEntity.get());
             repository.save(bookEntity.get());
        } else {
            throw new BookNotFoundException();
        }

    }

    /**
     * Method to delete book by ISBN.
     *
     * @param isbn
     * @return
     */
    @Override
    @Transactional
    public void deleteByIsbn(String isbn) {
        log.debug("delete bookDetails by ISBN");
        final Optional<BookEntity> bookEntity =
                Optional.ofNullable(repository.findByIsbn(isbn));
        if (bookEntity.isPresent()) {
            repository.deleteByIsbn(isbn);
        } else {
            throw new BookNotFoundException();
        }

    }

    /**
     * Method to find book by title.
     *
     * @param title
     * @return
     */
    @Override
    public SearchBooksResponse findByTitle(String title) {
        log.debug("Search books by Title");
        SearchBooksResponse response = new SearchBooksResponse();
        final List<BookEntity> bookEntity = repository.findByTitle(title);
        if(!CollectionUtils.isEmpty(bookEntity)) {
            response.setResult(mapper.toResponseList(bookEntity));
            return response;
        } else {
            throw new BookNotFoundException();
        }
    }

    /**
     * Method to get all books.
     *
     * @param pageNo
     * @param pageSize
     * @param sortBy
     * @param sortType
     *
     * @return
     */
    @Override
    public SearchBooksResponse getAllBooks(Integer pageNo, Integer pageSize, String sortBy, String sortType) {
        log.debug("Executing getAllBooks");
        Pageable paging;
        Page<BookEntity> pagedResult;
        if (sortType.equals("desc")) {
            paging = PageRequest.of(pageNo, pageSize, Sort
                    .by(sortBy)
                    .descending());
        } else {
            paging = PageRequest.of(pageNo, pageSize, Sort
                    .by(sortBy)
                    .ascending());
        }
        pagedResult = repository.findAll(paging);

        if (pagedResult.hasContent()) {

            List<BookDetailsResponse> responseList =
                    mapper.toResponseList(pagedResult.getContent());

            return new SearchBooksResponse(responseList, pagedResult.getTotalElements());
        } else {
            return new SearchBooksResponse();
        }
    }
}
