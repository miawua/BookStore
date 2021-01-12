package com.bookstore.bookstore;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.Record;
import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.service.BookService;
import com.bookstore.bookstore.service.RecordService;
import com.bookstore.bookstore.service.UserService;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
// @EnableJpaAuditing
public class RecordTest {
    @Autowired
    private RecordService rService;
    @Autowired
    private UserService uService;
    @Autowired
    private BookService bService;

    @Test
    public void add(){
        SimpleDateFormat format;
        Date date;
        try{
            uService.register(new User("u1", "p1"));
            format = new SimpleDateFormat("yyyy-MM-dd");
            date = new Date(format.parse("2020-10-23").getTime());
            Book b = new Book("iSBN", "bookname", "bookauthor", 10.5f, 5, 5, date, date, "picturelink", "text");
            bService.addBook(b);
            rService.addRecord(new Record("u1", 10.5f, "iSBN"));
        }catch(Exception e){}
    }
    @After
    public void del(){
        int ret = uService.deleteByName("u1");
        System.out.println(ret);
    }
}
