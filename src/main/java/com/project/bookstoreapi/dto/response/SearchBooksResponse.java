package com.project.bookstoreapi.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchBooksResponse {

    private static final long serialVersionUID = 3755501317748670152L;

    private List<BookDetailsResponse> result;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long totalBooks;

}
