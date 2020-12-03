package com.hivecloud.reading.service;

import com.hivecloud.reading.domain.dto.v1.CreateBookV1DTO;
import com.hivecloud.reading.domain.persistence.Book;
import com.hivecloud.reading.domain.persistence.User;
import com.hivecloud.reading.exceptions.BookNotFoundException;
import com.hivecloud.reading.repository.BookRepository;
import com.hivecloud.reading.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final BookRepository repository;

    public Book get(Long id) {
        return repository.findById(id).orElseThrow(BookNotFoundException::new);
    }

    public Long create(CreateBookV1DTO dto, User user) {
        Book book = new Book();
        book.setAuthor(dto.getAuthor());
        book.setYear(dto.getYear());
        book.setTitle(dto.getTitle());
        book.setPages(dto.getPages());
        book.setUser(user);
        return repository.save(book).getId();
    }
}
