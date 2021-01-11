package com.bookstore.bookstore.service;

import java.util.Optional;

import com.bookstore.bookstore.dao.BookDAO;
import com.bookstore.bookstore.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookDAO bDao;

    public int addBook(Book book){
        if(book == null) return 0;
        bDao.save(book);
        return 1;
    }

    public Book queryByISBN(String ISBN){
        Optional<Book> o = bDao.findById(ISBN);
        if(o.isEmpty()) return new Book();
        return o.get();
    }

    public int sell(Book book){
        if(book == null) return 0;
        Optional<Book> o = bDao.findById(book.getISBN());
        if(o.isEmpty()) return -1;
        book = o.get();
        bDao.updateSell(book.getSoldNum()+1, book.getRemainNum()-1, book.getISBN());
        return 1;
    }

    public int updateRemainNum(Book book){
        if(book == null) return 0;
        Optional<Book> o = bDao.findById(book.getISBN());
        if(o.isEmpty()) return -1;
        Book b = o.get();
        bDao.updateSell(b.getSoldNum(), book.getRemainNum(), b.getISBN());
        return 1;
    }
}
