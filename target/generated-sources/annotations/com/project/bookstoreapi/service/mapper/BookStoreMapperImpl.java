package com.project.bookstoreapi.service.mapper;

import com.project.bookstoreapi.dto.request.BookDetailsRequest;
import com.project.bookstoreapi.dto.response.BookDetailsResponse;
import com.project.bookstoreapi.model.BookEntity;
import com.project.bookstoreapi.util.CommonUtil;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-05-17T13:17:35+0530",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.19 (Ubuntu)"
)
@Component
public class BookStoreMapperImpl implements BookStoreMapper {

    @Override
    public BookEntity toEntity(BookDetailsRequest request) {
        if ( request == null ) {
            return null;
        }

        BookEntity bookEntity = new BookEntity();

        bookEntity.setTitle( request.getTitle() );
        bookEntity.setAuthor( request.getAuthor() );
        bookEntity.setIsbn( request.getIsbn() );
        if ( request.getPrice() != null ) {
            bookEntity.setPrice( Float.parseFloat( request.getPrice() ) );
        }
        bookEntity.setCreatedBy( request.getCreatedBy() );

        bookEntity.setCreatedDatetime( CommonUtil.getTimeStamp() );
        bookEntity.setPublicationDate( CommonUtil.toDate(request.getPublicationDate()) );

        return bookEntity;
    }

    @Override
    public BookDetailsResponse toResponse(BookEntity entity) {
        if ( entity == null ) {
            return null;
        }

        BookDetailsResponse bookDetailsResponse = new BookDetailsResponse();

        bookDetailsResponse.setTitle( entity.getTitle() );
        bookDetailsResponse.setAuthor( entity.getAuthor() );
        bookDetailsResponse.setIsbn( entity.getIsbn() );
        if ( entity.getPrice() != null ) {
            bookDetailsResponse.setPrice( String.valueOf( entity.getPrice() ) );
        }
        bookDetailsResponse.setUpdatedBy( entity.getUpdatedBy() );
        bookDetailsResponse.setCreatedBy( entity.getCreatedBy() );
        bookDetailsResponse.setUpdatedDatetime( entity.getUpdatedDatetime() );
        bookDetailsResponse.setCreatedDatetime( entity.getCreatedDatetime() );

        bookDetailsResponse.setPublicationDate( CommonUtil.fromDate(entity.getPublicationDate()) );

        return bookDetailsResponse;
    }

    @Override
    public void patch(BookDetailsRequest request, BookEntity entity) {
        if ( request == null ) {
            return;
        }

        if ( request.getTitle() != null ) {
            entity.setTitle( request.getTitle() );
        }
        if ( request.getAuthor() != null ) {
            entity.setAuthor( request.getAuthor() );
        }
        if ( request.getIsbn() != null ) {
            entity.setIsbn( request.getIsbn() );
        }
        if ( request.getPrice() != null ) {
            entity.setPrice( Float.parseFloat( request.getPrice() ) );
        }

        entity.setPublicationDate( CommonUtil.toDate(request.getPublicationDate()) );
        entity.setUpdatedDatetime( CommonUtil.getTimeStamp() );
    }

    @Override
    public List<BookDetailsResponse> toResponseList(List<BookEntity> entity) {
        if ( entity == null ) {
            return null;
        }

        List<BookDetailsResponse> list = new ArrayList<BookDetailsResponse>( entity.size() );
        for ( BookEntity bookEntity : entity ) {
            list.add( toResponse( bookEntity ) );
        }

        return list;
    }
}
