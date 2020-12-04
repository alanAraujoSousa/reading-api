package com.hivecloud.reading.domain.dto.v1;

import com.hivecloud.reading.domain.persistence.Book;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import java.time.LocalDate;

public interface BookReadersV1DTO {

    String getTitle();

    Long getReaders();

}
