package com.hivecloud.reading.domain.dto.v1;

import com.hivecloud.reading.domain.persistence.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateBookV1DTO {

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    @NotNull
    private Integer year;

    @NotNull
    @Min(1)
    private Integer pages;

    @Length(max = 255)
    private String reviewTitle;

    @Length(max = 1024)
    private String reviewContent;

    @Min(1)
    private Integer currentPage;

    @Max(5)
    @Min(0)
    private Integer currentRating;

    @Max(5)
    @Min(0)
    private Integer finalRating;

    @Pattern(regexp="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((?:19|20)[0-9][0-9])")
    private String startReadingDate;

    @Pattern(regexp="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((?:19|20)[0-9][0-9])")
    private String endReadingDate;

}
