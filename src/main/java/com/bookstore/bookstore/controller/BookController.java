package com.bookstore.bookstore.controller;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.bookstore.bookstore.entity.Book;
import com.bookstore.bookstore.entity.BookJSON;
import com.bookstore.bookstore.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    private BookService bService;

    @RequestMapping(value = "/book",  produces = "application/json;charset=UTF-8")
    public Object opt(@RequestBody Map<String, Object> oMap){
        BookJSON op = new BookJSON();
        if(oMap.get("opType") == null) return 0;
        op.setOpType((int)oMap.get("opType"));
        if(oMap.get("queryFrom") != null)
            op.setQueryFrom((int)oMap.get("queryFrom"));
        if(oMap.get("queryNum") != null)
            op.setQueryNum((int)oMap.get("queryNum"));
        if(oMap.get("order") != null)
            op.setOrder((String)oMap.get("order"));
        if(oMap.get("isAsc") != null)
            op.setAsc((boolean)oMap.get("isAsc"));
        if(oMap.get("book") != null){
            String rvs = JSONArray.toJSONString(oMap.get("book"));
            List<Book> b= JSON.parseArray(rvs, Book.class);
            op.setBook(b.get(0));
        }
        switch(op.getOpType()){
            case -1: return 0;
            case  0: {
                Book b = op.getBook();
                System.out.println(b.getISBN());
                System.out.println(b.getBookAuthor());
                System.out.println(b.getBookName());
                return bService.addBook(b);
            }
            case  1: return bService.sell(op.getBook());
            case  2: return bService.updateRemainNum(op.getBook());
            case  3: return bService.updateByISBN(op.getBook());
            case  4: return bService.queryByISBN(op.getBook().getISBN());
            case  5: return bService.queryBooks(op.getQueryFrom(), op.getQueryNum());
            case  6: return bService.queryByOrder(op.getQueryFrom(), op.getQueryNum(), op.getOrder(), op.isAsc());
            case  7: return bService.likeQuery(op.getBook());
        }
        return 1;
    }

}
