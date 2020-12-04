package com.hivecloud.reading.repository;

import com.hivecloud.reading.domain.dto.v1.BookReadersV1DTO;
import com.hivecloud.reading.domain.dto.v1.BookV1DTO;
import com.hivecloud.reading.domain.persistence.Book;
import com.hivecloud.reading.domain.persistence.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "select * from book b where b.user_id = ?1", nativeQuery = true)
    List<Book> findByUser(Long id);

    @Query(value = "select b.title as title, count(*) as readers from book b where b.user_id = ?1 group by b.title", nativeQuery = true)
    List<BookReadersV1DTO> listReaders(Long id);
}
