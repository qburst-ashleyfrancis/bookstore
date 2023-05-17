package com.project.bookstoreapi.repository;

import com.project.bookstoreapi.model.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface BookStoreRepository extends CrudRepository<BookEntity, Long>, JpaSpecificationExecutor<BookEntity> {

    BookEntity findByIsbn(String isbn);

    BookEntity findByBookId(Long bookId);

    Long deleteByIsbn(String isbn);

    List<BookEntity> findByTitle(String title);

    Page<BookEntity> findAll(Pageable p);
}
