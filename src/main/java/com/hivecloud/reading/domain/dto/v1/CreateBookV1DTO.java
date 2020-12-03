package com.hivecloud.reading.domain.dto.v1;

import com.hivecloud.reading.domain.persistence.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
public class CreateBookV1DTO {

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String author;

    @NotNull
    private Integer year;

    @NotNull
    @Min(1)
    private Integer pages;

}
