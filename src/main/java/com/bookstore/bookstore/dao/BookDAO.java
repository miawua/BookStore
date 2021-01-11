package com.bookstore.bookstore.dao;

import java.sql.Date;
import java.util.List;

import com.bookstore.bookstore.entity.Book;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Query(value = "select * from book limit ?1,?2", nativeQuery = true)
    List<Book> findBooks(int from, int num);

    @Query(value = "select * from book where isbn like %?1%", nativeQuery = true)
    List<Book> likeFindISBN(String likeISBN);

    @Query(value = "select * from book where bookname like %?1%", nativeQuery = true)
    List<Book> likeFindBName(String BName);

    @Query(value = "select * from book where bookauthor like %?1%", nativeQuery = true)
    List<Book> likeFindAName(String AName);

    @Query(value = "select * from book where text like %?1%", nativeQuery = true)
    List<Book> likeFindText(String text);

    Page<Book> findAll(Pageable p);
    // @Query(value = "select * from book ORDER BY ?1 asc limit ?2,?3")
    // List<Book> orderedFindA(String s, int from, int num);
    // @Query(value = "select * from book ORDER BY ?1 desc limit ?2,?3")
    // List<Book> orderedFindD(String s, int from, int num);

    @Query(value = "update book set soldnum = ?1, remainnum = ?2 where isbn = ?3", nativeQuery = true)
    @Modifying
    void updateSell(int sold, int remain, String isbn);

    @Query(value = "update book set price = ?1 where isbn = ?2", nativeQuery = true)
    @Modifying
    void updatePrice(float price, String ISBN);

    @Query(value = "update book set bookname=?1, bookauthor=?2, price=?3, soldnum=?4, remainnum=?5, shelftime=?6, releasetime=?7, picturelink=?8, text=?9 where isbn=?10", nativeQuery = true)
    @Modifying
    void updateByISBN(String bookname, String bookauthor, float price, int soldnum, int remainnum, Date shelftime, Date releasetime, String picturelink, String text, String ISBN);
}
