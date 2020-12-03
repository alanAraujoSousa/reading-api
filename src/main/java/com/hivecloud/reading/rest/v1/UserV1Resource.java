package com.hivecloud.reading.rest.v1;

import com.hivecloud.reading.constants.EndPointsV1;
import com.hivecloud.reading.domain.dto.v1.CreateUserV1DTO;
import com.hivecloud.reading.domain.dto.v1.UserV1DTO;
import com.hivecloud.reading.domain.persistence.User;
import com.hivecloud.reading.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Slf4j
@RestController
@RequestMapping(EndPointsV1.USER.ROOT)
@RequiredArgsConstructor
public class UserV1Resource {

    private final UserService service;
    private final ModelMapper modelMapper;

    @GetMapping(EndPointsV1.USER.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        User user = this.service.get(id);
        return ResponseEntity.ok(UserV1DTO.toEntity(user, modelMapper));
    }

    @PostMapping(EndPointsV1.USER.CREATE)
    public ResponseEntity signUp(@Validated @RequestBody CreateUserV1DTO dto) {
        Long id = service.register(dto);
        return ResponseEntity.created(URI.create(EndPointsV1.USER.ROOT + "/" + id))
                .build();
    }
}
