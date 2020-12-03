package com.hivecloud.reading.domain.dto.v1;

import com.hivecloud.reading.domain.persistence.User;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CreateUserV1DTO {

    @NotNull
    @NotEmpty
    @Size(min = 4, max = 48)
    private String login;

    @NotNull
    @NotEmpty
    @Size(min = 6, max = 48)
    private String password;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 56)
    private String name;
}
