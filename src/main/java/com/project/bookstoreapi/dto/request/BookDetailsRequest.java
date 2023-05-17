package com.project.bookstoreapi.dto.request;

import lombok.Data;

@Data
public class BookDetailsRequest {

    private static final long serialVersionUID = 6750293222373504470L;

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
    private String publicationDate;

    /**
     * price
     */
    private String price;

    /**
     * createdBy
     */
    private String createdBy;
}
