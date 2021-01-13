package com.bookstore.bookstore.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import com.bookstore.bookstore.dao.BookDAO;
import com.bookstore.bookstore.entity.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookDAO bDao;

    @Transactional
    public int addBook(Book book){
        if(book == null) return 0;
        bDao.save(book);
        return 1;
    }

    @Transactional
    public int addBooks(List<Book> books){
        if(books == null) return 0;
        int n = 0;
        for(Book b: books){
            if(addBook(b) == 1)
                n++;
        }
        return n;
    }

    public Book queryByISBN(String ISBN){
        Optional<Book> o = bDao.findById(ISBN);
        if(o.isEmpty()) return new Book();
        return o.get();
    }

    public List<Book> queryBooks(int from, int num){
        if(from < 0 || num < 1) return Collections.emptyList();
        return bDao.findBooks(from, num);
    }

    public List<Book> queryByOrder(int from, int num, String order, boolean isAsc){
        if(from < 0 || num < 1) return Collections.emptyList();
        Field[] fields = Book.class.getDeclaredFields();
        boolean flag = false;
        for(int i=0;i<fields.length;i++){
            if(fields[i].getName().equals(order)){
                flag = true;
                break;
            }
        }
        if(!flag) return Collections.emptyList();
        Sort s;
        if(isAsc) s = Sort.by(Sort.Direction.ASC, order);
        else s = Sort.by(Sort.Direction.DESC, order);
        Page<Book> bPage = bDao.findAll(PageRequest.of(from, num, s));
        return bPage.getContent();
    }

    public List<Book> likeQuery(Book book){
        if(book == null) return Collections.emptyList();
        Set<Book> bSet = new HashSet<Book>();
        if(book.getISBN() != null) 
            bSet.addAll(bDao.likeFindISBN(book.getISBN()));
        if(book.getBookName() != null)
            bSet.addAll(bDao.likeFindBName(book.getBookName()));
        if(book.getBookAuthor() != null)
            bSet.addAll(bDao.likeFindAName(book.getBookAuthor()));
        if(book.getText() != null)
            bSet.addAll(bDao.likeFindText(book.getText()));
        return new ArrayList<Book>(bSet);
    }

    @Transactional
    public int sell(Book book){
        if(book == null) return 0;
        Optional<Book> o = bDao.findById(book.getISBN());
        if(o.isEmpty()) return -1;
        book = o.get();
        System.out.println(book.getBookName());
        System.out.println(book.getSoldNum());
        System.out.println(book.getRemainNum());
        bDao.updateSell(book.getSoldNum()+1, book.getRemainNum()-1, book.getISBN());
        return 1;
    }

    @Transactional
    public int updateRemainNum(Book book){
        if(book == null) return 0;
        Optional<Book> o = bDao.findById(book.getISBN());
        if(o.isEmpty()) return -1;
        Book b = o.get();
        System.out.println(b.getBookName());
        System.out.println(b.getSoldNum());
        System.out.println(b.getRemainNum());
        bDao.updateSell(b.getSoldNum(), book.getRemainNum(), b.getISBN());
        return 1;
    }

    @Transactional
    public int updateByISBN(Book book){
        if(book == null) return 0;
        Optional<Book> o = bDao.findById(book.getISBN());
        if(o.isEmpty()) return -1;
        Book b = o.get();
        bDao.updateByISBN(book.getBookName() != null ? book.getBookName(): b.getBookName(), 
                          book.getBookAuthor() != null ? book.getBookAuthor(): b.getBookAuthor(), 
                          book.getPrice() != 0 ? book.getPrice(): b.getPrice(), 
                          book.getSoldNum() != 0 ? book.getSoldNum(): b.getSoldNum(), 
                          book.getRemainNum() != 0 ? book.getRemainNum(): b.getRemainNum(), 
                          book.getShelfTime() != null ? book.getShelfTime(): b.getShelfTime(), 
                          book.getReleaseTime() != null ? book.getReleaseTime(): b.getReleaseTime(), 
                          book.getPictureLink() != null ? book.getPictureLink(): b.getPictureLink(), 
                          book.getText() != null ? book.getText(): b.getText(), 
                          book.getISBN());
        return 1;
    }
}
