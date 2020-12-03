package com.hivecloud.reading.domain.dto.v1;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Getter
@Setter
public class BookReadV1DTO {

    @Length(max = 255)
    private String reviewTitle;

    @Length(max = 1024)
    private String reviewContent;

    @Min(1)
    private Integer currentPage;

    @Max(5)
    @Min(0)
    private Integer finalRating;

    @NotBlank
    @Pattern(regexp="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((?:19|20)[0-9][0-9])")
    private String endReadingDate;

}
