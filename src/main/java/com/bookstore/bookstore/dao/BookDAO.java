package com.bookstore.bookstore.dao;

import com.bookstore.bookstore.entity.Book;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@EntityScan(basePackages = {"com.bookstore.bookstore.entity"})
public interface BookDAO extends JpaRepository<Book, String> {
    @Modifying
    @Transactional
    @Query(value = "delete from book b where b.ISBN = ?1", nativeQuery = true)
    void deleteByISBN(String name);

    @Query(value = "update book set soldnum = ?1 and remainnum = ?2 where isbn = ?3", nativeQuery = true)
    @Modifying
    void updateSell(int sold, int remain, String isbn);
}
