package com.bookstore.bookstore;

import java.text.SimpleDateFormat;
import java.sql.Date;

import com.bookstore.bookstore.dao.BookDAO;
import com.bookstore.bookstore.entity.Book;

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
            book = new Book();
            book.setBook("ISBN", "bookname", "bookauthor", 25.6f, 1, 11, date, date, "https");
            bDao.save(book);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @After
    public void after() {
        bDao.deleteByISBN("1111-11111");
        bDao.flush();
    }
}
