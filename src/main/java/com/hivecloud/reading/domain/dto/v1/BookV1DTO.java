package com.hivecloud.reading.domain.dto.v1;

import com.hivecloud.reading.constants.CommonConstants;
import com.hivecloud.reading.domain.persistence.Book;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Getter
@Setter
public class BookV1DTO {

    private Long id;

    private String title;

    private String author;

    private Integer year;

    private Integer pages;

    private String reviewTitle;

    private String reviewContent;

    private Integer currentPage;

    private Integer currentRating;

    private Integer finalRating;

    private LocalDate startReadingDate;

    private LocalDate endReadingDate;

    private Long readers;

    public static BookV1DTO toEntity(Book book, ModelMapper modelMapper) {
        return modelMapper.map(book, BookV1DTO.class);
    }
}
