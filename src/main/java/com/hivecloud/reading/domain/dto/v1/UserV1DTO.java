package com.hivecloud.reading.domain.dto.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hivecloud.reading.domain.persistence.User;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.persistence.Column;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class UserV1DTO {

    @NotNull
    @Positive
    private Long id;

    private String login;

    @JsonIgnore
    private String password;

    private String name;

    private List<BookV1DTO> books;

    public static UserV1DTO toEntity(User user, ModelMapper modelMapper) {
        return modelMapper.map(user, UserV1DTO.class);
    }

    public void setBooks(List<BookV1DTO> books) {
        this.books = books;
    }
}
