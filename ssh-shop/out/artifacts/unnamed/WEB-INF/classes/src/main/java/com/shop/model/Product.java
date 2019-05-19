package com.shop.model;

import lombok.Data;
import sun.security.krb5.internal.Ticket;

import javax.persistence.*;
import java.util.Date;

//product
@Table(name="Product")
@Entity
@Data
public class Product {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    private Integer pid;
    private String pname;
    private Float market_price;
    private Float shop_price;
    private Integer inventory;
    private String image;
    private String pdesc;
    private Integer is_hot;
    private Date pdate;

    //The second category,foreign key,second category object
    @JoinColumn(name="csid")
    @ManyToOne
    private CategorySecond categorySecond;
    // ticket foreign key
    @OneToOne(cascade = {CascadeType.REFRESH}, fetch = FetchType.EAGER, mappedBy = "category")
    private Ticket ticket;
}
