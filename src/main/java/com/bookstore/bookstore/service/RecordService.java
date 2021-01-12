package com.bookstore.bookstore.service;

import java.util.List;
import java.util.Optional;

import com.bookstore.bookstore.dao.BookDAO;
import com.bookstore.bookstore.dao.RecordDAO;
import com.bookstore.bookstore.dao.UserDAO;
import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.Record;
import com.bookstore.bookstore.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RecordService {
    @Autowired
    private RecordDAO rDao;
    @Autowired
    private UserDAO uDao;
    @Autowired
    private BookDAO bDao;
    @Autowired
    private BookService bService;

    public int addRecord(String username, String ISBN){
        if(username == null || ISBN == null) return 0;
        Optional<User> u = uDao.findById(username);
        if(u.isEmpty()) return -1;
        Optional<Book> b = bDao.findById(ISBN);
        if(b.isEmpty()) return -1;
        return addRecord(new Record(username, b.get().getPrice(), ISBN));
    }

    public int addRecord(Record record){
        if(record == null) return 0;
        if(record.getBuyername() == null) return -1;
        User buyer = uDao.findByName(record.getBuyername());
        if(buyer == null) return -1;
        if(record.getISBN() == null) return -1;
        Optional<Book> book = bDao.findById(record.getISBN());
        if(book.isEmpty()) return -1;
        bService.sell(book.get());
        rDao.save(record);
        return 1;
    }

    @Transactional
    public int deleteUserRecord(String username){
        Optional<User> u = uDao.findById(username);
        if(u.isEmpty()) return -1;
        rDao.deleteUserRecord(username);
        return 1;
    }

    public List<Record> findUserRecords(String username){
        Optional<User> u = uDao.findById(username);
        if(u.isEmpty()) return null;
        return rDao.findUserRecords(username);
    }

    @Transactional
    public int deleteBookRecord(String ISBN){
        Optional<Book> b = bDao.findById(ISBN);
        if(b.isEmpty()) return -1;
        rDao.deleteBookRecord(ISBN);
        return 1;
    }

    public List<Record> findBookRecords(String ISBN){
        Optional<Book> b = bDao.findById(ISBN);
        if(b.isEmpty()) return null;
        return rDao.findBookRecords(ISBN);
    }
}
