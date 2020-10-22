package com.bookstore.bookstore.dao;

import com.bookstore.bookstore.entity.User;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
@EntityScan(basePackages = {"com.bookstore.bookstore.entity"})
public interface UserDAO extends JpaRepository<User, Long>{
    
}
