package com.hivecloud.reading.domain.dto.v1;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class ReadingBookV1DTO {

    @NotNull
    @Min(1)
    private Integer currentPage;

    @Min(0)
    private Integer currentRating;

    @Pattern(regexp="(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((?:19|20)[0-9][0-9])")
    private String startReadingDate;

}
