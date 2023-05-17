package com.project.bookstoreapi.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class BookDetailsResponse {

    private static final long serialVersionUID = 4245014531637735316L;

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
     * updatedBy
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String updatedBy;

    /**
     * createdBy
     */
    private String createdBy;

    /**
     * updatedDateTime
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Timestamp updatedDatetime;

    /**
     * createdDateTime
     */
    private Timestamp createdDatetime;
}
