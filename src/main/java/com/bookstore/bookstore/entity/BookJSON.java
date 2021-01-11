package com.bookstore.bookstore.entity;

public class BookJSON {
    /**
     * -1 no operation
     * 0 add a book
     *      book is requried and must be completed
     * 1 sell a book
     *      book is requried and ISBN is requried
     * 2 purchase one book(maybe not use)
     *      book is requried and ISBN and a new remain num are requried
     * 3 update a book
     *      book is requried and must be completed
     * 4 query by ISBN
     *      book is requried and just ISBN is requried
     * 5 query books by index
     *      queryFrom is query starts from where
     *      queryNum is how many are queried
     * 6 query books by order
     *      queryFrom is query starts from where
     *      queryNum is how many are queried
     *      order is sort rules which is must be an attribute in class Book
     *      isAsc is true when sorting in ascending order
     * 7 likely query by isbn or/and bookname or/and bookauthor
     *      book {isbn,bookname,bookauthor}
     * 
     * important: because of the JSON object contain a entity, so the 'book' should be a list
     *  for example:
     *  {
     *      "opType": -1,
     *      "book":[{
     *            "isbn": "111"
     *       }]
     *  }
     */
    int opType;
    int queryFrom;
    int queryNum;
    String order;
    boolean isAsc;
    Book book;

    public BookJSON() {
        opType = -1;
    }

    public BookJSON(int opType, int queryFrom, int queryNum, String order, boolean isAsc, Book book) {
        this.opType = opType;
        this.queryFrom = queryFrom;
        this.queryNum = queryNum;
        this.order = order;
        this.isAsc = isAsc;
        this.book = book;
    }

    public BookJSON(int opType, int queryFrom, int queryNum, String order, boolean isAsc) {
        this.opType = opType;
        this.queryFrom = queryFrom;
        this.queryNum = queryNum;
        this.order = order;
        this.isAsc = isAsc;
    }

    public BookJSON(int opType, Book book) {
        this.opType = opType;
        this.book = book;
    }

    public BookJSON(int opType, int queryFrom, int queryNum) {
        this.opType = opType;
        this.queryFrom = queryFrom;
        this.queryNum = queryNum;
    }

    public int getOpType() {
        return opType;
    }

    public void setOpType(int opType) {
        this.opType = opType;
    }

    public int getQueryFrom() {
        return queryFrom;
    }

    public void setQueryFrom(int queryFrom) {
        this.queryFrom = queryFrom;
    }

    public int getQueryNum() {
        return queryNum;
    }

    public void setQueryNum(int queryNum) {
        this.queryNum = queryNum;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public boolean isAsc() {
        return isAsc;
    }

    public void setAsc(boolean isAsc) {
        this.isAsc = isAsc;
    }
}
