package com.project.bookstoreapi.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "bookstore", schema = "book")
@Data
public class BookEntity {

    /**
     * bookId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", unique = true, nullable = false, insertable = false, updatable = false)
    private Long bookId;

    /**
     * title
     */
    private String title;

    /**
     * author
     */
    private String author;

    /**
     * isbn
     */
    private String isbn;

    /**
     * publicationDate
     */
    private Date publicationDate;

    /**
     * price
     */
    private Float price;

    /**
     * updatedBy
     */
    private String updatedBy;

    /**
     * createdBy
     */
    private String createdBy;

    /**
     * updatedDateTime
     */
    private Timestamp updatedDatetime;

    /**
     * createdDateTime
     */
    private Timestamp createdDatetime;
}
