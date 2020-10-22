package com.bookstore.bookstore;

import com.bookstore.bookstore.dao.UserDAO;
import com.bookstore.bookstore.entity.User;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
    @Autowired
    private UserDAO uDao;

    @Before
    public void before() {
        User user = new User();
        user.setId(1L);
        user.setUsername("u1");
        user.setPassword("p1");
        uDao.save(user);
        user = new User();
        user.setId(2L);
        user.setUsername("u2");
        user.setPassword("p2");
        uDao.save(user);
        user = new User();
        user.setId(3L);
        user.setUsername("u3");
        user.setPassword("p3");
        uDao.save(user);
    }
    @Test
    public void testAdd() {
        User user = new User();
        user.setId(4L);
        user.setUsername("u4");
        user.setPassword("p4");
        uDao.save(user);
        user = new User();
        user.setId(5L);
        user.setUsername("u5");
        user.setPassword("p5");
        uDao.save(user);
        user = new User();
        user.setId(7L);
        user.setUsername("u6");
        user.setPassword("p7");
        uDao.save(user);
    }
    @After
    public void after() {
        uDao.deleteById(1L);
        uDao.deleteById(3L);
        uDao.deleteById(5L);
    }
}
