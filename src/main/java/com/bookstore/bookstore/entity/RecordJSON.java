package com.bookstore.bookstore.entity;

public class RecordJSON {
    /**
     * -1 no operation
     * 0 add a record
     *      ISBN is which book will be traded
     *      username is who will trade
     * 1 delete records by username
     *      username(who will clear his/her records or who will be deleted)
     * 2 find records by username
     *      username
     * 3 delete records by isbn
     *      ISBN(which book will be deleted)
     * 4 find records by isbn
     *      ISBN
     */
    int opType;
    String ISBN;
    String username;

    public RecordJSON(){
        opType = -1;
    }

    public RecordJSON(int opType, String iSBN, String username) {
        this.opType = opType;
        ISBN = iSBN;
        this.username = username;
    }

    public int getOpType() {
        return opType;
    }

    public void setOpType(int opType) {
        this.opType = opType;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
