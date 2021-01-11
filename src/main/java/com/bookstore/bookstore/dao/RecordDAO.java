package com.bookstore.bookstore.dao;

import java.util.List;

import com.bookstore.bookstore.entity.Record;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan(basePackages = {"com.bookstore.bookstore.entity"})
public interface RecordDAO extends JpaRepository<Record, Long> {
    @Modifying
    @Query(value = "delete from record where buyername = ?1", nativeQuery = true)
    void deleteUserRecord(String username);

    @Query(value = "select * from record where buyername = ?1", nativeQuery = true)
    List<Record> findUserRecords(String username);

    @Modifying
    @Query(value = "delete from record where isbn = ?1", nativeQuery = true)
    void deleteBookRecord(String ISBN);

    @Query(value = "select * from record where isbn = ?1", nativeQuery = true)
    List<Record> findBookRecords(String ISBN);
}
