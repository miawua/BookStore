package com.bookstore.bookstore.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.CreationTimestamp;
// import org.springframework.data.annotation.CreatedDate;
import org.springframework.format.annotation.NumberFormat;

@Entity
@Table(name = "book")
// @JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "isbn", length = 255)
    String ISBN;

    @Column(length = 64)
    String bookname;

    @Column(length = 64)
    String bookauthor;

    @NumberFormat(pattern = ".##")
    float price;
    int soldnum;
    int remainnum;

    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone
    // = "GMT+8")
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private Date shelftime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    Date releasetime;
    // https://sm.ms/image/3GRZheF49UrqjmY][img]https://i.loli.net/2020/10/23/3GRZheF49UrqjmY.png
    
    @Column(name = "picturelink", length = 255)
    String picturelink;
    @Column(columnDefinition="text")
    String text;

    public Book(String iSBN) {
        ISBN = iSBN;
    }

    public Book(String iSBN, String bookname, String bookauthor) {
        ISBN = iSBN;
        this.bookname = bookname;
        this.bookauthor = bookauthor;
    }

    public Book(String iSBN, int remainnum) {
        ISBN = iSBN;
        this.remainnum = remainnum;
    }

    public Book(String iSBN, String bookname, String bookauthor, float price, int soldnum, int remainnum,
            Date releasetime, String picturelink, String text) {
        ISBN = iSBN;
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.price = price;
        this.soldnum = soldnum;
        this.remainnum = remainnum;
        this.releasetime = releasetime;
        this.picturelink = picturelink;
        this.text = text;
    }

    public Book(String iSBN, String bookname, String bookauthor, float price, int soldnum, int remainnum,
            Date shelftime, Date releasetime, String picturelink, String text) {
        ISBN = iSBN;
        this.bookname = bookname;
        this.bookauthor = bookauthor;
        this.price = price;
        this.soldnum = soldnum;
        this.remainnum = remainnum;
        this.shelftime = shelftime;
        this.releasetime = releasetime;
        this.picturelink = picturelink;
        this.text = text;
    }

    public Book(String iSBN, int soldnum, int remainnum) {
        ISBN = iSBN;
        this.soldnum = soldnum;
        this.remainnum = remainnum;
    }

    public Book(){
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getBookName() {
        return bookname;
    }

    public void setBookName(String bookname) {
        this.bookname = bookname;
    }

    public String getBookAuthor() {
        return bookauthor;
    }

    public void setBookAuthor(String bookauthor) {
        this.bookauthor = bookauthor;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getSoldNum() {
        return soldnum;
    }

    public void setSoldNum(int soldnum) {
        this.soldnum = soldnum;
    }

    public int getRemainNum() {
        return remainnum;
    }

    public void setRemainNum(int remainnum) {
        this.remainnum = remainnum;
    }

    public Date getShelfTime() {
        return shelftime;
    }

    public void setShelfTime(Date shelftime) {
        this.shelftime = shelftime;
    }

    public Date getReleaseTime() {
        return releasetime;
    }

    public void setReleaseTime(Date releasetime) {
        this.releasetime = releasetime;
    }

    public String getPictureLink() {
        return picturelink;
    }

    public void setPictureLink(String picturelink) {
        this.picturelink = picturelink;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
