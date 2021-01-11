package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.dao.BookDAO;
import com.bookstore.bookstore.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {
    "/",
    "/home",
    "/home/*"
})
public class BookController {
    @Autowired
    private BookDAO bDao;

    @RequestMapping("/book")
    public boolean add(Book book){
        bDao.save(book);
        return true;
    }
}
