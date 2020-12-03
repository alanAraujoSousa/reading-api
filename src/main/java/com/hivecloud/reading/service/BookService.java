package com.hivecloud.reading.service;

import com.hivecloud.reading.domain.dto.v1.BookReadV1DTO;
import com.hivecloud.reading.domain.dto.v1.CreateBookV1DTO;
import com.hivecloud.reading.domain.dto.v1.ReadingBookV1DTO;
import com.hivecloud.reading.domain.persistence.Book;
import com.hivecloud.reading.domain.persistence.User;
import com.hivecloud.reading.exceptions.BookNotFoundException;
import com.hivecloud.reading.repository.BookRepository;
import com.hivecloud.reading.utils.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

        book.setCurrentPage(dto.getCurrentPage());
        book.setCurrentRating(dto.getCurrentRating());
        book.setFinalRating(dto.getFinalRating());

        book.setReviewTitle(dto.getReviewTitle());
        book.setReviewContent(dto.getReviewContent());

        String startReadingDate = dto.getStartReadingDate();
        if (!StringUtils.isEmpty(startReadingDate)) {
            book.setStartReadingDate(DateUtils.parseDate(startReadingDate));
        }

        String endReadingDate = dto.getEndReadingDate();
        if (!StringUtils.isEmpty(endReadingDate)) {
            book.setEndReadingDate(DateUtils.parseDate(endReadingDate));
        }

        book.setUser(user);
        return repository.save(book).getId();
    }

    public void reading(ReadingBookV1DTO dto, Book book) {

        Integer currentPage = dto.getCurrentPage();
        Integer currentRating = dto.getCurrentRating();
        String startReadingDate = dto.getStartReadingDate();

        book.setCurrentPage(currentPage);

        if (currentRating != null) {
            book.setCurrentRating(currentRating);
        }

        if (!StringUtils.isEmpty(startReadingDate)) {
            book.setStartReadingDate(DateUtils.parseDate(startReadingDate));
        }

        repository.save(book);
    }

    public void read(BookReadV1DTO dto, Book book) {

        Integer currentPage = dto.getCurrentPage();
        Integer finalRating = dto.getFinalRating();
        String reviewTitle = dto.getReviewTitle();
        String reviewContent = dto.getReviewContent();
        String endReadingDate = dto.getEndReadingDate();

        if (currentPage != null) {
            book.setCurrentPage(currentPage);
        }

        if (finalRating != null) {
            book.setFinalRating(finalRating);
        }

        if (!StringUtils.isEmpty(reviewTitle)) {
            book.setReviewTitle(reviewTitle);
        }

        if (!StringUtils.isEmpty(reviewContent)) {
            book.setReviewContent(reviewContent);
        }

        book.setEndReadingDate(DateUtils.parseDate(endReadingDate));

        repository.save(book);
    }
}
