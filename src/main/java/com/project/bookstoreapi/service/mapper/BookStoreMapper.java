package com.project.bookstoreapi.service.mapper;

import com.project.bookstoreapi.dto.request.BookDetailsRequest;
import com.project.bookstoreapi.dto.response.BookDetailsResponse;
import com.project.bookstoreapi.model.BookEntity;
import com.project.bookstoreapi.util.CommonUtil;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", imports = {CommonUtil.class})
public interface BookStoreMapper {

    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "updatedDatetime" , ignore = true)
    @Mapping(target = "createdDatetime" , expression = "java( CommonUtil.getTimeStamp())")
    @Mapping(target = "publicationDate" , expression = "java( CommonUtil.toDate(request.getPublicationDate()))")
    BookEntity toEntity(BookDetailsRequest request);

    @Mapping(target = "publicationDate" , expression = "java( CommonUtil.fromDate(entity.getPublicationDate()))")
    BookDetailsResponse toResponse(BookEntity entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "createdDatetime", ignore = true)
    @Mapping(target = "bookId", ignore = true)
    @Mapping(target = "updatedDatetime" , expression = "java( CommonUtil.getTimeStamp())")
    @Mapping(target = "publicationDate" , expression = "java( CommonUtil.toDate(request.getPublicationDate()))")
    void patch(BookDetailsRequest request, @MappingTarget BookEntity entity) ;

    List<BookDetailsResponse> toResponseList(List<BookEntity> entity);
}
