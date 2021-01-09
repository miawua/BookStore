package com.bookstore.bookstore.controller;

import com.bookstore.bookstore.dao.UserDAO;
import com.bookstore.bookstore.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    static int key = 0;

    @Autowired
    private UserDAO uDao;

    @RequestMapping(value = "/login/json", produces = "application/json;charset=UTF-8")
    public int loginJSON(@RequestBody User user){
        String find = uDao.findByNameForPass(user.getUsername());
        if(find == null) return -1; // account not exits
        char[] password = user.getPassword().toCharArray();
        char[] truePass = find.toCharArray();
        if(password.length != truePass.length) return -2; // password error
        for(int i=0;i<password.length;i++){
            password[i] = (char)(password[i]^key);
            if(password[i] != truePass[i])
                return -3; // password error
        }
        return 1;
    }

    @RequestMapping("/login")
    public int login(User user){
        String find = uDao.findByNameForPass(user.getUsername());
        if(find == null) return -1; // account not exits
        char[] password = user.getPassword().toCharArray();
        char[] truePass = find.toCharArray();
        if(password.length != truePass.length) return -2; // password error
        for(int i=0;i<password.length;i++){
            password[i] = (char)(password[i]^key);
            if(password[i] != truePass[i])
                return -3; // password error
        }
        return 1;
    }

    @RequestMapping(value = "/register/json", produces = "application/json;charset=UTF-8")
    public int registerJSON(@RequestBody User user){
        User find = uDao.findByName(user.getUsername());
        if(find != null) return 0; // account exits
        char[] password = user.getPassword().toCharArray();
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        for(int i=0;i<password.length;i++){
            password[i] = (char)(password[i]^key);
        }
        uDao.save(user);
        return 1;
    }

    @RequestMapping(value = "/register")
    public int register(User user){
        User find = uDao.findByName(user.getUsername());
        if(find != null) return 0; // account exits
        char[] passwords = user.getPassword().toCharArray();
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        for(int i=0;i<passwords.length;i++){
            passwords[i] = (char)(passwords[i]^key);
        }
        uDao.save(user);
        return 1;
    }
}
