package com.bookstore.bookstore.entity;

import java.util.List;

public class UserJSON {
    /**
     * -1 no operation
     * 0 login, just one user
     * 1 register, just one user
     * 2 update user's username, two elements in users, users[0]=new, users[1]=old
     *      for old one, just username is required
     *      for new one, just username is required
     * 3 update user's password, one element just
     *      username and password are required, password is the new one
     * 4 update user's address, one element
     *      username and address are required
     * 5 update user's username and other, two elements
     *      for old one, just username is required
     *      for new one, username and password/address are required
     * 6 update user's password or/and address, one element
     *      username, password/address are required
     */
    int opType;
    List<User> users;

    public UserJSON(){
        opType = -1;
    }
    public UserJSON(int opType, List<User> users){
        setOpType(opType);
        setUsers(users);
    }

    public int getOpType() {
        return opType;
    }

    public void setOpType(int opType) {
        this.opType = opType;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

}
