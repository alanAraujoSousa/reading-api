package com.hivecloud.reading.domain.persistence;

import com.hivecloud.reading.constants.CommonConstants;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "book")
@Setter
@Getter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "year", nullable = false)
    private Integer year;

    @Column(name = "pages", nullable = false)
    private Integer pages;

    @Column(name = "reviewTitle")
    private String reviewTitle;

    @Column(name = "reviewContent", length = 1024)
    private String reviewContent;

    @Column(name = "currentPage")
    private Integer currentPage;

    @Column(name = "currentRating")
    private Integer currentRating;

    @Column(name = "finalRating")
    private Integer finalRating;

    @Column(name = "start_reading_date")
    @DateTimeFormat(pattern = CommonConstants.DATE_PATTERN)
    private LocalDate startReadingDate;

    @Column(name = "end_reading_date")
    @DateTimeFormat(pattern = CommonConstants.DATE_PATTERN)
    private LocalDate endReadingDate;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
