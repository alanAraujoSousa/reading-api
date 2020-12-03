package com.hivecloud.reading.rest.v1;

import com.hivecloud.reading.constants.EndPointsV1;
import com.hivecloud.reading.domain.dto.v1.BookV1DTO;
import com.hivecloud.reading.domain.dto.v1.CreateBookV1DTO;
import com.hivecloud.reading.domain.persistence.Book;
import com.hivecloud.reading.domain.persistence.User;
import com.hivecloud.reading.service.BookService;
import com.hivecloud.reading.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(EndPointsV1.BOOK.ROOT)
@RequiredArgsConstructor
public class BookV1Resource {

    private final BookService service;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping(EndPointsV1.BOOK.GET)
    public ResponseEntity get(@PathVariable("id") Long id) {
        Book book = this.service.get(id);
        return ResponseEntity.ok(BookV1DTO.toEntity(book, modelMapper));
    }

    @PostMapping
    public ResponseEntity create(@Validated @RequestBody CreateBookV1DTO dto, Authentication authentication) {

        String subject = Jwts.claims((Map<String, Object>) authentication.getPrincipal()).getSubject();
        User user = userService.get(subject);
        Long id = service.create(dto, user);
        return ResponseEntity.created(URI.create(EndPointsV1.BOOK.ROOT + "/" + id))
                .build();
    }
}
