package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.entity.RecordJSON;
import com.bookstore.bookstore.service.RecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = {
    "/",
    "/*"
})
public class RecordController {
    @Autowired
    private RecordService rService;

    @RequestMapping(value = "/buy", produces = "application/json;charset=UTF-8")
    public Object opt(@RequestBody RecordJSON op){
        if(op == null) return 0;
        switch(op.getOpType()){
            case -1: return -1;
            case  0: return rService.addRecord(op.getUsername(), op.getISBN());
            case  1: return rService.deleteUserRecord(op.getUsername());
            case  2: return rService.findUserRecords(op.getUsername());
            case  3: return rService.deleteBookRecord(op.getISBN());
            case  4: return rService.findBookRecords(op.getISBN());
        }
        return 1;
    }
}
