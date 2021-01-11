package com.bookstore.bookstore.dao;

import com.bookstore.bookstore.entity.User;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@EntityScan(basePackages = {"com.bookstore.bookstore.entity"})
public interface UserDAO extends JpaRepository<User, String>{
    @Query(value = "select * from user u where u.username = ?1", nativeQuery = true)
    User findByName(String name);

    @Query(value = "select password from user u where u.username = ?1", nativeQuery = true)
    String findByNameForPass(String name);

    @Query(value = "update user set username = ?1 where username = ?2", nativeQuery = true)
    @Modifying
    void updateName(String newName, String name);
    
    @Query(value = "update user set password = ?1 where username = ?2", nativeQuery = true)
    @Modifying
    void updatePass(String newPass, String name);
    
    @Query(value = "update user set address = ?1 where username = ?2", nativeQuery = true)
    @Modifying
    void updateAddress(String newAddress, String name);
    
    @Query(value = "update user set username = ?1 and password = ?2 where username = ?3", nativeQuery = true)
    @Modifying
    void updateNamePass(String newName, String newPass, String name);
    
    @Query(value = "update user set password = ?1 and address = ?2 where username = ?3", nativeQuery = true)
    @Modifying
    void updatePassAddr(String newPass, String newAddr, String name);
    
    @Query(value = "update user set username = ?1 and password = ?2 and address = ?3 where username = ?4", nativeQuery = true)
    @Modifying
    void updateUser(String newName, String newPass, String newAddr, String name);
}
