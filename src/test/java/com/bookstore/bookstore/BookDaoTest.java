package com.bookstore.bookstore;

import java.text.SimpleDateFormat;
import java.util.List;
import java.sql.Date;

import com.bookstore.bookstore.dao.BookDAO;
import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.service.BookService;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookDaoTest {
    @Autowired
    BookDAO bDao;
    @Autowired
    BookService bService;

    @Test
    public void testAdd() {
        Book book = new Book();
        SimpleDateFormat format;
        Date date;
        try{
            book.setISBN("1111-11111");
            book.setBookName("1");
            book.setBookAuthor("ba1");
            book.setPictureLink("http");
            book.setPrice(1.5f);
            format = new SimpleDateFormat("yyyy-MM-dd");
            date = new Date(format.parse("2020-10-23").getTime()); 
            book.setReleaseTime(date);
            // book.setShelfTime(date);
            book.setSoldNum(10);
            book.setRemainNum(5);
            bDao.save(book);
            book = new Book("ISBN1", "bookname", "bookauthor", 251.6f, 1, 11, date, date, "https", "");
            bDao.save(book);
            book = new Book("ISBN2", "bookname", "bookauthor", 253.6f, 1, 11, date, date, "https", "");
            bDao.save(book);
            book = new Book("ISBN3", "bookname", "bookauthor", 252.6f, 1, 11, date, date, "https", "");
            bDao.save(book);
            book = new Book("ISBN4", "bookname", "bookauthor", 2522.6f, 1, 11, date, date, "https", "");
            bDao.save(book);
            book = new Book("ISBN5", "bookname", "bookauthor", 251.6f, 1, 11, date, date, "https", "");
            bDao.save(book);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @After
    public void after() {
        // bDao.deleteByISBN("1111-11111");
        // bDao.flush();
        // List<Book> books = bDao.findBooks(2, 4);
        // for(Book b: books){
        //     System.out.println(b.getISBN());
        // }
        List<Book> books = bService.queryByOrder(0, 3, "price", false);
        for(Book b: books){
            System.out.println(b.getISBN());
        }
    }
}
