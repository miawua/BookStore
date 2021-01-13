package com.bookstore.bookstore.controller;

import java.util.List;

import com.bookstore.bookstore.entity.User;
import com.bookstore.bookstore.entity.UserJSON;
import com.bookstore.bookstore.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.annotation.Reference;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService uService;

    @RequestMapping(value = "/", produces = "application/json;charset=UTF-8")
    public int opt(@RequestBody UserJSON op){
        if(op == null) return 0;
        if(op.getUsers() == null){
            System.out.println("null");
            return 0;
        }
        List<User> user = op.getUsers();
        int length = user.size();
        if(length < 1) return 0;
        switch(op.getOpType()){
            case -1: return 0;
            case  0: return uService.login(user.get(0));
            case  1: return uService.register(user.get(0));
            case  2:
                if(length < 2) return 0;
                return uService.updateName(user.get(1), user.get(0).getUsername());
            case  3: return uService.updatePass(user.get(0), user.get(0).getPassword());
            case  4: return uService.updateAddr(user.get(0), user.get(0).getAddress());
            case  5:
                if(length < 2) return 0;
                return uService.update(user.get(0), user.get(1));
            case  6: return uService.updateNoName(user.get(0));
            case  7: return uService.register(user);
        }
        return 0;
    }

    @RequestMapping(value = "/login/json", produces = "application/json;charset=UTF-8")
    public int loginJSON(@RequestBody User user){
        return uService.login(user);
    }

    @RequestMapping("/login")
    public int login(User user){
        return uService.login(user);
    }

    @RequestMapping(value = "/register/json", produces = "application/json;charset=UTF-8")
    public int registerJSON(@RequestBody User user){
        return uService.register(user);
    }

    @RequestMapping(value = "/register")
    public int register(User user){
        return uService.register(user);
    }

    @RequestMapping(value = "/update/json", produces = "application/json;charset=UTF-8")
    public int updateJSON(@RequestBody List<User> users){
        User newUser = users.get(0);
        User oldUser = users.get(1);
        uService.update(newUser, oldUser);
        return 1;
    }

}
