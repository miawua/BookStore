package com.bookstore.bookstore.dao;

import com.bookstore.bookstore.entity.User;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan(basePackages = {"com.bookstore.bookstore.entity"})
public interface UserDAO extends JpaRepository<User, String>{
    @Query(value = "select * from user u where u.username=?1", nativeQuery = true)
    User findByName(String name);

    @Query(value = "select password from user u where u.username = ?1", nativeQuery = true)
    String findByNameForPass(String name);
}
