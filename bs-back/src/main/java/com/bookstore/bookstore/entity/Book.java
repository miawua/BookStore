package com.bookstore.bookstore.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
// import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "book")
// @JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ISBN", length = 255)
    String ISBN;

    @Column(length = 64)
    String bookname;

    @Column(length = 64)
    String bookauthor;

    float price;
    int soldnum;
    int remainnum;

    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone
    // = "GMT+8")
    @CreatedDate
    @Column(columnDefinition = "date")
    private Date shelftime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    Date releasetime;
    // https://sm.ms/image/3GRZheF49UrqjmY][img]https://i.loli.net/2020/10/23/3GRZheF49UrqjmY.png
    String picturelink;

    public void setBook(String ISBN, String bookname, String bookauthor, float price, int soldnum, int remainnum,
            Date shelftime, Date releasetime, String picturelink) {
        setISBN(ISBN);
        setBookName(bookname);
        setBookAuthor(bookauthor);
        setPrice(price);
        setSoldNum(soldnum);
        setRemainNum(remainnum);
        setShelfTime(shelftime);
        setReleaseTime(releasetime);
        setPictureLink(picturelink);
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
}
