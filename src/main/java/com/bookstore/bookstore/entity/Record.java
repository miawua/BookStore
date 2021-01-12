package com.bookstore.bookstore.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
// import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "record")
@EntityListeners(AuditingEntityListener.class)
public class Record implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    Long id;
    @Column(length = 32)
    String buyername; // mapping to username
    
    @CreationTimestamp
    @Column(columnDefinition = "date")
    Date purchasedate;
    
    float payfor;
    @Column(length = 255)
    String ISBN;

    public Record(){}
    public Record(String username, float payfor, String ISBN){
        this.buyername = username;
        this.payfor = payfor;
        this.ISBN = ISBN;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBuyername() {
        return buyername;
    }

    public void setBuyername(String buyername) {
        this.buyername = buyername;
    }

    public Date getPurchasedate() {
        return purchasedate;
    }

    public void setPurchasedate(Date purchasedate) {
        this.purchasedate = purchasedate;
    }

    public float getPayfor() {
        return payfor;
    }

    public void setPayfor(float payfor) {
        this.payfor = payfor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }
    
}
