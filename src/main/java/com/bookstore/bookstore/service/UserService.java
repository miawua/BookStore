package com.bookstore.bookstore.service;

import java.util.List;

import javax.transaction.Transactional;

import com.bookstore.bookstore.dao.RecordDAO;
import com.bookstore.bookstore.dao.UserDAO;
import com.bookstore.bookstore.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDAO uDao;
    @Autowired
    private RecordDAO rDao;

    static int key = 0;

    public int login(User user){
        if(user == null) return 0;
        String find = uDao.findByNameForPass(user.getUsername());
        if(find == null) return -1; // account not exists
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

    @Transactional
    public int register(User user){
        if(user == null) return 0;
        User find = uDao.findByName(user.getUsername());
        if(find != null) return -1; // account exists
        char[] password = user.getPassword().toCharArray();
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        for(int i=0;i<password.length;i++){
            password[i] = (char)(password[i]^key);
        }
        uDao.save(user);
        return 1;
    }

    @Transactional
    public int register(List<User> users){
        if(users == null) return 0;
        int n = 0;
        for(User u: users){
            if(register(u) == 1)
                n++;
        }
        return n;
    }

    @Transactional
    public int update(User newUser, User oldUser){
        if(newUser == null || oldUser == null) return 0;
        if(newUser.getUsername().equals(oldUser.getUsername())){
            return updateNoName(newUser);
        }
        User o = uDao.findByName(newUser.getUsername());
        if(o != null) return -2; // new name already exists
        o = uDao.findByName(oldUser.getUsername());
        if(o == null) return -1; // user not exists
        String newName = newUser.getUsername();
        String oldName = oldUser.getUsername();
        uDao.updateUser(newUser.getUsername(), newUser.getPassword(), newUser.getAddress(), o.getUsername());
        rDao.updateByUsername(newName, oldName);
        return 1;
    }

    @Transactional
    public int updateNoName(User user){
        if(user == null) return 0;
        User u = uDao.findByName(user.getUsername());
        if(u == null) return -1; // user not exists
        uDao.updatePassAddr(user.getPassword(), user.getAddress(), user.getUsername());
        return 1;
    }

    @Transactional
    public int updateName(User user, String newName){
        if(user == null) return 0;
        User u = uDao.findByName(user.getUsername());
        if(u == null) return -1; // user not exists
        String oldName = u.getUsername();
        uDao.updateName(newName, u.getUsername());
        rDao.updateByUsername(newName, oldName);
        return 1;
    }

    @Transactional
    public int updatePass(User user, String newPass){
        if(user == null) return 0;
        User u = uDao.findByName(user.getUsername());
        if(u == null) return -1; // user not exists
        uDao.updatePass(newPass, u.getUsername());
        return 1;
    }

    @Transactional
    public int updateAddr(User user, String newAddr){
        if(user == null) return 0;
        User u = uDao.findByName(user.getUsername());
        if(u == null) return -1; // user not exists
        uDao.updateAddress(newAddr, u.getUsername());
        return 1;
    }

    @Transactional
    public int delete(User user){
        if(user == null) return 0;
        User u = uDao.findByName(user.getUsername());
        if(u == null) return -1;
        uDao.deleteById(user.getUsername());
        rDao.deleteUserRecord(user.getUsername());
        return 1;
    }

    @Transactional
    public int deleteByName(String username){
        if(username == null) return 0;
        User u = uDao.findByName(username);
        if(u == null) return -1;
        uDao.deleteById(username);
        rDao.deleteUserRecord(username);
        return 1;
    }
}
