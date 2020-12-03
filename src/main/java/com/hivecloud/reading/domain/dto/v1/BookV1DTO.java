package com.hivecloud.reading.domain.dto.v1;

import com.hivecloud.reading.domain.persistence.Book;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Getter
@Setter
public class BookV1DTO {

    @NotNull
    @Positive
    private Long id;

    public static BookV1DTO toEntity(Book book, ModelMapper modelMapper) {
        return modelMapper.map(book, BookV1DTO.class);
    }
}
